package com.example.hikitchen.util;

/**
 * Created by Administrator on 2019/5/15.
 */

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.baidu.aip.asrwakeup3.core.mini.AutoCheck;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.asr.SpeechConstant;
import com.example.hikitchen.eventbus.Event;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  集成文档： http://ai.baidu.com/docs#/ASR-Android-SDK/top 集成指南一节
 *  demo目录下doc_integration_DOCUMENT
 *      ASR-INTEGRATION-helloworld  ASR集成指南-集成到helloworld中 对应 ActivityMiniRecog
 *      ASR-INTEGRATION-TTS-DEMO ASR集成指南-集成到合成DEMO中 对应 ActivityRecog
 */

public class RecogUtil implements EventListener {
    protected static Context ctx;
    // protected TextView txtLog;
    //   protected TextView txtResult;
    //  protected Button btn;
    //  protected Button stopBtn;
    private static String DESC_TEXT = "精简版识别，带有SDK唤醒运行的最少代码，仅仅展示如何调用，\n" +
            "也可以用来反馈测试SDK输入参数及输出回调。\n" +
            "本示例需要自行根据文档填写参数，可以使用之前识别示例中的日志中的参数。\n" +
            "需要完整版请参见之前的识别示例。\n" +
            "需要测试离线命令词识别功能可以将本类中的enableOffline改成true，首次测试离线命令词请联网使用。之后请说出“打电话给张三”";

    private EventManager asr;

    private boolean logTime = true;

    protected boolean enableOffline = false; // 测试离线命令词，需要改成true
    private static RecogUtil recog;

    public static RecogUtil getInstance(Context context) {
        ctx=context;
        if (recog == null) {
            synchronized (RecogUtil.class) {
                if (recog == null) {
                    recog = new RecogUtil(context);
                }
            }
        }
        return recog;
    }
    public RecogUtil(final Context context) {
        initTTs(context);
    }

    private void initTTs(Context context) {
        asr = EventManagerFactory.create(context, "asr");
        // 基于sdk集成1.3 注册自己的输出事件类
        asr.registerListener(this); //  EventListener 中 onEvent方法
        if (enableOffline) {
            loadOfflineEngine(); // 测试离线命令词请开启, 测试 ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH 参数时开启
        }
    }
    /**
     * 基于SDK集成2.2 发送开始事件
     * 点击开始按钮
     * 测试参数填在这里
     */
    public void start() {
        //  txtLog.setText("");
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        String event = null;
        event = SpeechConstant.ASR_START; // 替换成测试的event
        if (enableOffline) {
            params.put(SpeechConstant.DECODER, 2);
        }
        // 基于SDK集成2.1 设置识别参数
        params.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, false);
        // params.put(SpeechConstant.NLU, "enable");
        params.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 0); // 长语音
        // params.put(SpeechConstant.IN_FILE, "res:///com/baidu/android/voicedemo/16k_test.pcm");
        // params.put(SpeechConstant.VAD, SpeechConstant.VAD_DNN);
        // params.put(SpeechConstant.PID, 1537); // 中文输入法模型，有逗号
        // 请先使用如‘在线识别’界面测试和生成识别参数。 params同ActivityRecog类中myRecognizer.start(params);
        // 复制此段可以自动检测错误
        (new AutoCheck(ctx, new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 100) {
                    AutoCheck autoCheck = (AutoCheck) msg.obj;
                    synchronized (autoCheck) {
                        String message = autoCheck.obtainErrorMessage(); // autoCheck.obtainAllMessage();
                        //txtLog.append(message + "\n");
                        // 可以用下面一行替代，在logcat中查看代码
                        // Log.w("AutoCheckMessage", message);
                    }
                }
            }
        },enableOffline)).checkAsr(params);
        String json = null; // 可以替换成自己的json
        json = new JSONObject(params).toString(); // 这里可以替换成你需要测试的json
        asr.send(event, json, null, 0, 0);
        printLog("输入参数：" + json);
    }

    /**
     * 点击停止按钮
     *  基于SDK集成4.1 发送停止事件
     */
    public void stop() {
        printLog("停止识别：ASR_STOP");
        asr.send(SpeechConstant.ASR_STOP, null, null, 0, 0); //
    }


    /**
     * enableOffline设为true时，在onCreate中调用
     * 基于SDK离线命令词1.4 加载离线资源(离线时使用)
     */
    private void loadOfflineEngine() {
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        params.put(SpeechConstant.DECODER, 2);
        params.put(SpeechConstant.ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH, "assets://baidu_speech_grammar.bsg");
        asr.send(SpeechConstant.ASR_KWS_LOAD_ENGINE, new JSONObject(params).toString(), null, 0, 0);
    }

    /**
     * enableOffline为true时，在onDestory中调用，与loadOfflineEngine对应
     * 基于SDK集成5.1 卸载离线资源步骤(离线时使用)
     */
    private void unloadOfflineEngine() {
        asr.send(SpeechConstant.ASR_KWS_UNLOAD_ENGINE, null, null, 0, 0); //
    }

    /* @Override
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(test2.baidu.com.baseasr.R.layout.common_mini);
        initView();
        initPermission();
        // 基于sdk集成1.1 初始化EventManager对象
    asr = EventManagerFactory.create(this, "asr");
    // 基于sdk集成1.3 注册自己的输出事件类
    asr.registerListener(this); //  EventListener 中 onEvent方法
    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            start();
        }
    });
    stopBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            stop();
        }
    });
    if (enableOffline) {
        loadOfflineEngine(); // 测试离线命令词请开启, 测试 ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH 参数时开启
    }
    }*/


    public void onPause(){
        recog.onPause();
        asr.send(SpeechConstant.ASR_CANCEL, "{}", null, 0, 0);
        Log.i("ActivityMiniRecog","On pause");
    }


    public void onDestroy() {
        recog.onDestroy();
        // 基于SDK集成4.2 发送取消事件
        asr.send(SpeechConstant.ASR_CANCEL, "{}", null, 0, 0);
        if (enableOffline) {
            unloadOfflineEngine(); // 测试离线命令词请开启, 测试 ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH 参数时开启
        }

        // 基于SDK集成5.2 退出事件管理器
        // 必须与registerListener成对出现，否则可能造成内存泄露
        asr.unregisterListener(this);
    }

    // 基于sdk集成1.2 自定义输出事件类 EventListener 回调方法
    // 基于SDK集成3.1 开始回调事件
    @Override
    public void onEvent(String name, String params, byte[] data, int offset, int length) {

        String logTxt = "name: " + name;
        if (params != null && !params.isEmpty()) {
            logTxt += " ;params :" + params;
        }
        if (name.equals(SpeechConstant.CALLBACK_EVENT_ASR_PARTIAL)) {
            if(params != null && params.contains("\"final_result\"")) {
                JSONObject newObj1 = null;
                String result="1";
                try {
                    newObj1 = new JSONObject(params);
                    //获取其中的属性值
                    result =newObj1.getString("best_result");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                EventBus.getDefault().post(new Event(result));
            }
          /*  if (params != null && params.contains("\"nlu_result\"")) {
                if (length > 0 && data.length > 0) {
                    logTxt += ", 语义解析结果：" + new String(data, offset, length);

                }
            }*/


        } else if (data != null) {
            logTxt += " ;data length=" + data.length;
        }
        printLog(logTxt);

    }

    public void printLog(String text) {
        if (logTime) {
            text += "  ;time=" + System.currentTimeMillis();
        }
        text += "\n";
        Log.i(getClass().getName(), text);
        //txtLog.append(text + "\n");
    }


    // private void initView() {
    // txtResult = (TextView) findViewById(test2.baidu.com.baseasr.R.id.txtResult);
    //  txtLog = (TextView) findViewById(test2.baidu.com.baseasr.R.id.txtLog);
    //  btn = (Button) findViewById(test2.baidu.com.baseasr.R.id.btn);
    //  stopBtn = (Button) findViewById(test2.baidu.com.baseasr.R.id.btn_stop);
    //      txtLog.setText(DESC_TEXT + "\n");
    //  }

    /**
     * android 6.0 以上需要动态申请权限
     */


}

