package com.example.hikitchen;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KindsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KindsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KindsFragment extends Fragment implements View.OnClickListener {
    //private String content;
    public static KindsFragment newInstance() {
        KindsFragment newFragment = new KindsFragment();
        // Bundle bundle = new Bundle();
        // bundle.putString("content", content);
        // newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kinds, container, false);
        //TextView txt_content = (TextView) view.findViewById(R.id.fg_kinds);
        //txt_content.setText(content);

        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        Bundle args = getArguments();
        if (args != null) {
        content= args.getString("content");
        }
        */

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化按钮控件
        Button buttonLucai = (Button) getActivity().findViewById(R.id.bt_lucai);
        buttonLucai.setOnClickListener(this);
        Button buttonChuancai = (Button) getActivity().findViewById(R.id.bt_chuancai);
        buttonChuancai.setOnClickListener(this);
        Button buttonLYuecai = (Button) getActivity().findViewById(R.id.bt_yuecai);
        buttonLYuecai.setOnClickListener(this);
        Button buttonHuaiynagcai = (Button) getActivity().findViewById(R.id.bt_huaiyangcai);
        buttonHuaiynagcai.setOnClickListener(this);
        Button buttonZhecai = (Button) getActivity().findViewById(R.id.bt_zhecai);
        buttonZhecai.setOnClickListener(this);
        Button buttonMincai = (Button) getActivity().findViewById(R.id.bt_mincai);
        buttonMincai.setOnClickListener(this);
        Button buttonHuicai = (Button) getActivity().findViewById(R.id.bt_huicai);
        buttonHuicai.setOnClickListener(this);
        Button buttonXiangcai = (Button) getActivity().findViewById(R.id.bt_xiangcai);
        buttonXiangcai.setOnClickListener(this);
        Button buttonRibencai = (Button) getActivity().findViewById(R.id.bt_ribencai);
        buttonRibencai.setOnClickListener(this);
        Button buttonHanguocai = (Button) getActivity().findViewById(R.id.bt_hanguocai);
        buttonHanguocai.setOnClickListener(this);
        Button buttonFaguocai = (Button) getActivity().findViewById(R.id.bt_faguocai);
        buttonFaguocai.setOnClickListener(this);
        Button buttonYidalicai = (Button) getActivity().findViewById(R.id.bt_yidalicai);
        buttonYidalicai.setOnClickListener(this);
        Button buttonTaiguocai = (Button) getActivity().findViewById(R.id.bt_taiguocai);
        buttonTaiguocai.setOnClickListener(this);
        Button buttonMianshi = (Button) getActivity().findViewById(R.id.bt_mianshi);
        buttonMianshi.setOnClickListener(this);
        Button buttonMifan = (Button) getActivity().findViewById(R.id.bt_mifan);
        buttonMifan.setOnClickListener(this);
        Button buttonBinglei = (Button) getActivity().findViewById(R.id.bt_binglei);
        buttonBinglei.setOnClickListener(this);
        Button buttonZhou = (Button) getActivity().findViewById(R.id.bt_zhou);
        buttonZhou.setOnClickListener(this);
        Button buttonDangao = (Button) getActivity().findViewById(R.id.bt_dangao);
        buttonDangao.setOnClickListener(this);
        Button buttonMianbao = (Button) getActivity().findViewById(R.id.bt_mianbao);
        buttonMianbao.setOnClickListener(this);
        Button buttonBinggan = (Button) getActivity().findViewById(R.id.bt_binggan);
        buttonBinggan.setOnClickListener(this);
        Button buttonPisa = (Button) getActivity().findViewById(R.id.bt_pisa);
        buttonPisa.setOnClickListener(this);
        Button buttonZhurou = (Button) getActivity().findViewById(R.id.bt_zhurou);
        buttonZhurou.setOnClickListener(this);
        Button buttonYangrou = (Button) getActivity().findViewById(R.id.bt_yangrou);
        buttonYangrou.setOnClickListener(this);
        Button buttonNiurou = (Button) getActivity().findViewById(R.id.bt_niurou);
        buttonNiurou.setOnClickListener(this);
        Button buttonJirou = (Button) getActivity().findViewById(R.id.bt_jirou);
        buttonJirou.setOnClickListener(this);
        Button buttonYarou = (Button) getActivity().findViewById(R.id.bt_yarou);
        buttonYarou.setOnClickListener(this);
        Button buttonCaoyu = (Button) getActivity().findViewById(R.id.bt_caoyu);
        buttonCaoyu.setOnClickListener(this);
        Button buttonLuyu = (Button) getActivity().findViewById(R.id.bt_luyu);
        buttonLuyu.setOnClickListener(this);
        Button buttonDaiyu = (Button) getActivity().findViewById(R.id.bt_daiyu);
        buttonDaiyu.setOnClickListener(this);
        Button buttonSanwenyu = (Button) getActivity().findViewById(R.id.bt_sanwenyu);
        buttonSanwenyu.setOnClickListener(this);
        Button buttonXiaren = (Button) getActivity().findViewById(R.id.bt_xiaren);
        buttonXiaren.setOnClickListener(this);
        Button buttonWenge = (Button) getActivity().findViewById(R.id.bt_wenge);
        buttonWenge.setOnClickListener(this);
        Button buttonJidan = (Button) getActivity().findViewById(R.id.bt_jidan);
        buttonJidan.setOnClickListener(this);
        Button buttonAnchundan = (Button) getActivity().findViewById(R.id.bt_anchundan);
        buttonAnchundan.setOnClickListener(this);
        Button buttonXiandan = (Button) getActivity().findViewById(R.id.bt_xiandan);
        buttonXiandan.setOnClickListener(this);
        Button buttonPidan = (Button) getActivity().findViewById(R.id.bt_pidan);
        buttonPidan.setOnClickListener(this);
        Button buttonQiezi = (Button) getActivity().findViewById(R.id.bt_qiezi);
        buttonQiezi.setOnClickListener(this);
        Button buttonHuluobo = (Button) getActivity().findViewById(R.id.bt_huluobo);
        buttonHuluobo.setOnClickListener(this);
        Button buttonBaicai = (Button) getActivity().findViewById(R.id.bt_baicai);
        buttonBaicai.setOnClickListener(this);
        Button buttonWosun = (Button) getActivity().findViewById(R.id.bt_wosun);
        buttonWosun.setOnClickListener(this);
        Button buttonShengcai = (Button) getActivity().findViewById(R.id.bt_shengcai);
        buttonShengcai.setOnClickListener(this);
        Button buttonXilanhua = (Button) getActivity().findViewById(R.id.bt_xilanhua);
        buttonXilanhua.setOnClickListener(this);
        Button buttonXihongshi = (Button) getActivity().findViewById(R.id.bt_xihongshi);
        buttonXihongshi.setOnClickListener(this);
        Button buttonShanyao = (Button) getActivity().findViewById(R.id.bt_shanyao);
        buttonShanyao.setOnClickListener(this);
        Button buttonGuozhi = (Button) getActivity().findViewById(R.id.bt_guozhi);
        buttonGuozhi.setOnClickListener(this);
        Button buttonDunpin = (Button) getActivity().findViewById(R.id.bt_dunpin);
        buttonDunpin.setOnClickListener(this);
        Button buttonGuochayinpin = (Button) getActivity().findViewById(R.id.bt_guochayinpin);
        buttonGuochayinpin.setOnClickListener(this);
        Button buttonBingpin = (Button) getActivity().findViewById(R.id.bt_bingpin);
        buttonBingpin.setOnClickListener(this);
        Button buttonTanggeng = (Button) getActivity().findViewById(R.id.bt_tanggeng);
        buttonTanggeng.setOnClickListener(this);
        Button buttonTangshui = (Button) getActivity().findViewById(R.id.bt_tangshui);
        buttonTangshui.setOnClickListener(this);
    }

    @Override
    //判断点击的是哪个按钮，并设置id
    public void onClick(View v) {
        int id = 0;
        Context context = getActivity();
        switch (v.getId()) {
            case R.id.bt_lucai:
                id = 13;
                break;
            case R.id.bt_chuancai:
                id = 10;
                break;
            case R.id.bt_yuecai:
                id = 11;
                break;
            case R.id.bt_huaiyangcai:
                id = 115;
                break;
            case R.id.bt_zhecai:
                id = 102;
                break;
            case R.id.bt_mincai:
                id = 101;
                break;
            case R.id.bt_huicai:
                id = 105;
                break;
            case R.id.bt_xiangcai:
                id = 12;
                break;
            case R.id.bt_ribencai:
                id = 17;
                break;
            case R.id.bt_hanguocai:
                id = 18;
                break;
            case R.id.bt_faguocai:
                id = 125;
                break;
            case R.id.bt_yidalicai:
                id = 124;
                break;
            case R.id.bt_taiguocai:
                id = 123;
                break;
            case R.id.bt_mianshi:
                id = 66;
                break;
            case R.id.bt_mifan:
                id = 64;
                break;
            case R.id.bt_binglei:
                id = 68;
                break;
            case R.id.bt_zhou:
                id = 65;
                break;
            case R.id.bt_dangao:
                id = 73;
                break;
            case R.id.bt_mianbao:
                id = 74;
                break;
            case R.id.bt_binggan:
                id = 75;
                break;
            case R.id.bt_pisa:
                id = 76;
                break;
            case R.id.bt_zhurou:
                id = 182;
                break;
            case R.id.bt_yangrou:
                id = 183;
                break;
            case R.id.bt_niurou:
                id = 184;
                break;
            case R.id.bt_jirou:
                id = 191;
                break;
            case R.id.bt_yarou:
                id = 195;
                break;
            case R.id.bt_caoyu:
                id = 201;
                break;
            case R.id.bt_luyu:
                id = 202;
                break;
            case R.id.bt_daiyu:
                id = 203;
                break;
            case R.id.bt_sanwenyu:
                id = 204;
                break;
            case R.id.bt_xiaren:
                id = 205;
                break;
            case R.id.bt_wenge:
                id = 206;
                break;
            case R.id.bt_jidan:
                id = 194;
                break;
            case R.id.bt_anchundan:
                id = 199;
                break;
            case R.id.bt_xiandan:
                id = 197;
                break;
            case R.id.bt_pidan:
                id = 198;
                break;
            case R.id.bt_qiezi:
                id = 210;
                break;
            case R.id.bt_huluobo:
                id = 211;
                break;
            case R.id.bt_baicai:
                id = 212;
                break;
            case R.id.bt_wosun:
                id = 213;
                break;
            case R.id.bt_shengcai:
                id = 214;
                break;
            case R.id.bt_xilanhua:
                id = 217;
                break;
            case R.id.bt_xihongshi:
                id = 216;
                break;
            case R.id.bt_shanyao:
                id = 215;
                break;
            case R.id.bt_guozhi:
                id = 83;
                break;
            case R.id.bt_dunpin:
                id = 84;
                break;
            case R.id.bt_guochayinpin:
                id = 88;
                break;
            case R.id.bt_bingpin:
                id = 89;
                break;
            case R.id.bt_tanggeng:
                id = 82;
                break;
            case R.id.bt_tangshui:
                id = 85;
                break;
        }
        Intent intent = new Intent(context, GetMenuActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);//向getmenuactivity传入id,并启动getmenuactivity
    }
}
