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
    public class KindsFragment extends Fragment implements View.OnClickListener{
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
        View view = inflater.inflate(R.layout.fragment_kinds,container,false);
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
        Button buttonLucai=(Button)getActivity().findViewById(R.id.bt_lucai);
        buttonLucai.setOnClickListener(this);
        Button buttonChuancai=(Button)getActivity().findViewById(R.id.bt_chuancai);
        buttonChuancai.setOnClickListener(this);
        Button buttonLYuecai=(Button)getActivity().findViewById(R.id.bt_yuecai);
        buttonLYuecai.setOnClickListener(this);
        Button buttonHuaiynagcai=(Button)getActivity().findViewById(R.id.bt_huaiyangcai);
        buttonHuaiynagcai.setOnClickListener(this);
        Button buttonZhecai=(Button)getActivity().findViewById(R.id.bt_zhecai);
        buttonZhecai.setOnClickListener(this);
        Button buttonMincai=(Button)getActivity().findViewById(R.id.bt_mincai);
        buttonMincai.setOnClickListener(this);
        Button buttonHuicai=(Button)getActivity().findViewById(R.id.bt_huicai);
        buttonHuicai.setOnClickListener(this);
        Button buttonXiangcai=(Button)getActivity().findViewById(R.id.bt_xiangcai);
        buttonXiangcai.setOnClickListener(this);
        Button buttonRibencai=(Button)getActivity().findViewById(R.id.bt_ribencai);
        buttonRibencai.setOnClickListener(this);
        Button buttonHanguocai=(Button)getActivity().findViewById(R.id.bt_hanguocai);
        buttonHanguocai.setOnClickListener(this);
        Button buttonFaguocai=(Button)getActivity().findViewById(R.id.bt_faguocai);
        buttonFaguocai.setOnClickListener(this);
        Button buttonYidalicai=(Button)getActivity().findViewById(R.id.bt_yidalicai);
        buttonYidalicai.setOnClickListener(this);
        Button buttonTaiguocai=(Button)getActivity().findViewById(R.id.bt_taiguocai);
        buttonTaiguocai.setOnClickListener(this);
        Button buttonMianshi=(Button)getActivity().findViewById(R.id.bt_mianshi);
        buttonMianshi.setOnClickListener(this);
        Button buttonMifan=(Button)getActivity().findViewById(R.id.bt_mifan);
        buttonMifan.setOnClickListener(this);
        Button buttonBinglei=(Button)getActivity().findViewById(R.id.bt_binglei);
        buttonBinglei.setOnClickListener(this);
        Button buttonZhou=(Button)getActivity().findViewById(R.id.bt_zhou);
        buttonZhou.setOnClickListener(this);
        Button buttonDangao=(Button)getActivity().findViewById(R.id.bt_dangao);
        buttonDangao.setOnClickListener(this);
        Button buttonMianbao=(Button)getActivity().findViewById(R.id.bt_mianbao);
        buttonMianbao.setOnClickListener(this);
        Button buttonBinggan=(Button)getActivity().findViewById(R.id.bt_binggan);
        buttonBinggan.setOnClickListener(this);
        Button buttonPisa=(Button)getActivity().findViewById(R.id.bt_pisa);
        buttonPisa.setOnClickListener(this);
        Button buttonZhurou=(Button)getActivity().findViewById(R.id.bt_zhurou);
        buttonZhurou.setOnClickListener(this);
        Button buttonYangrou=(Button)getActivity().findViewById(R.id.bt_yangrou);
        buttonYangrou.setOnClickListener(this);
        Button buttonNiurou=(Button)getActivity().findViewById(R.id.bt_niurou);
        buttonNiurou.setOnClickListener(this);
        Button buttonJirou=(Button)getActivity().findViewById(R.id.bt_jirou);
        buttonJirou.setOnClickListener(this);
        Button buttonYarou=(Button)getActivity().findViewById(R.id.bt_yarou);
        buttonYarou.setOnClickListener(this);
        Button buttonCaoyu=(Button)getActivity().findViewById(R.id.bt_caoyu);
        buttonCaoyu.setOnClickListener(this);
        Button buttonLuyu=(Button)getActivity().findViewById(R.id.bt_luyu);
        buttonLuyu.setOnClickListener(this);
        Button buttonDaiyu=(Button)getActivity().findViewById(R.id.bt_daiyu);
        buttonDaiyu.setOnClickListener(this);
        Button buttonSanwenyu=(Button)getActivity().findViewById(R.id.bt_sanwenyu);
        buttonSanwenyu.setOnClickListener(this);
        Button buttonXiaren=(Button)getActivity().findViewById(R.id.bt_xiaren);
        buttonXiaren.setOnClickListener(this);
        Button buttonWenge=(Button)getActivity().findViewById(R.id.bt_wenge);
        buttonWenge.setOnClickListener(this);
        Button buttonJidan=(Button)getActivity().findViewById(R.id.bt_jidan);
        buttonJidan.setOnClickListener(this);
        Button buttonAnchundan=(Button)getActivity().findViewById(R.id.bt_anchundan);
        buttonAnchundan.setOnClickListener(this);
        Button buttonXiandan=(Button)getActivity().findViewById(R.id.bt_xiandan);
        buttonXiandan.setOnClickListener(this);
        Button buttonPidan=(Button)getActivity().findViewById(R.id.bt_pidan);
        buttonPidan.setOnClickListener(this);
        Button buttonQiezi=(Button)getActivity().findViewById(R.id.bt_qiezi);
        buttonQiezi.setOnClickListener(this);
        Button buttonHuluobo=(Button)getActivity().findViewById(R.id.bt_huluobo);
        buttonHuluobo.setOnClickListener(this);
        Button buttonBaicai=(Button)getActivity().findViewById(R.id.bt_baicai);
        buttonBaicai.setOnClickListener(this);
        Button buttonWosun=(Button)getActivity().findViewById(R.id.bt_wosun);
        buttonWosun.setOnClickListener(this);
        Button buttonShengcai=(Button)getActivity().findViewById(R.id.bt_shengcai);
        buttonShengcai.setOnClickListener(this);
        Button buttonXilanhua=(Button)getActivity().findViewById(R.id.bt_xilanhua);
        buttonXilanhua.setOnClickListener(this);
        Button buttonXihongshi=(Button)getActivity().findViewById(R.id.bt_xihongshi);
        buttonXihongshi.setOnClickListener(this);
        Button buttonShanyao=(Button)getActivity().findViewById(R.id.bt_shanyao);
        buttonShanyao.setOnClickListener(this);
        Button buttonGuozhi=(Button)getActivity().findViewById(R.id.bt_guozhi);
        buttonGuozhi.setOnClickListener(this);
        Button buttonDunpin=(Button)getActivity().findViewById(R.id.bt_dunpin);
        buttonDunpin.setOnClickListener(this);
        Button buttonGuochayinpin=(Button)getActivity().findViewById(R.id.bt_guochayinpin);
        buttonGuochayinpin.setOnClickListener(this);
        Button buttonBingpin=(Button)getActivity().findViewById(R.id.bt_bingpin);
        buttonBingpin.setOnClickListener(this);
        Button buttonTanggeng=(Button)getActivity().findViewById(R.id.bt_tanggeng);
        buttonTanggeng.setOnClickListener(this);
        Button buttonTangshui=(Button)getActivity().findViewById(R.id.bt_tangshui);
        buttonTangshui.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //int id;
        Context context = getActivity();
        switch(v.getId()){
            case R.id.bt_lucai:
                int id=13;
                Intent intent=new Intent(context,GetMenuActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
               // Toast.makeText(getActivity(), "nihao1", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_chuancai:
                Toast.makeText(getActivity(), "nihao2", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_yuecai:
                Toast.makeText(getActivity(), "nihao3", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_huaiyangcai:
                Toast.makeText(getActivity(), "nihao4", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_zhecai:
                Toast.makeText(getActivity(), "nihao5", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_mincai:
                Toast.makeText(getActivity(), "nihao6", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_huicai:
                Toast.makeText(getActivity(), "nihao7", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_xiangcai:
                Toast.makeText(getActivity(), "nihao8", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_ribencai:
                Toast.makeText(getActivity(), "nihao9", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_hanguocai:
                Toast.makeText(getActivity(), "nihao10", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_faguocai:
                Toast.makeText(getActivity(), "nihao11", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_yidalicai:
                Toast.makeText(getActivity(), "nihao12", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_taiguocai:
                Toast.makeText(getActivity(), "nihao13", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_mianshi:
                Toast.makeText(getActivity(), "nihao14", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_mifan:
                Toast.makeText(getActivity(), "nihao15", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_binglei:
                Toast.makeText(getActivity(), "nihao16", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_zhou:
                Toast.makeText(getActivity(), "nihao17", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_dangao:
                Toast.makeText(getActivity(), "nihao18", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_mianbao:
                Toast.makeText(getActivity(), "nihao19", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_binggan:
                Toast.makeText(getActivity(), "nihao20", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_pisa:
                Toast.makeText(getActivity(), "nihao21", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_zhurou:
                Toast.makeText(getActivity(), "nihao22", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_yangrou:
                Toast.makeText(getActivity(), "nihao23", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_niurou:
                Toast.makeText(getActivity(), "nihao24", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_jirou:
                Toast.makeText(getActivity(), "nihao25", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_yarou:
                Toast.makeText(getActivity(), "nihao26", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_caoyu:
                Toast.makeText(getActivity(), "nihao27", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_luyu:
                Toast.makeText(getActivity(), "nihao28", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_daiyu:
                Toast.makeText(getActivity(), "nihao29", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_sanwenyu:
                Toast.makeText(getActivity(), "nihao30", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_xiaren:
                Toast.makeText(getActivity(), "nihao31", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_wenge:
                Toast.makeText(getActivity(), "nihao32", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_jidan:
                Toast.makeText(getActivity(), "nihao33", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_anchundan:
                Toast.makeText(getActivity(), "nihao34", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_xiandan:
                Toast.makeText(getActivity(), "nihao35", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_pidan:
                Toast.makeText(getActivity(), "nihao36", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_qiezi:
                Toast.makeText(getActivity(), "nihao37", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_huluobo:
                Toast.makeText(getActivity(), "nihao38", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_baicai:
                Toast.makeText(getActivity(), "nihao39", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_wosun:
                Toast.makeText(getActivity(), "nihao40", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_shengcai:
                Toast.makeText(getActivity(), "nihao41", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_xilanhua:
                Toast.makeText(getActivity(), "nihao42", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_xihongshi:
                Toast.makeText(getActivity(), "nihao43", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_shanyao:
                Toast.makeText(getActivity(), "nihao44", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_guozhi:
                Toast.makeText(getActivity(), "nihao45", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_dunpin:
                Toast.makeText(getActivity(), "nihao46", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_guochayinpin:
                Toast.makeText(getActivity(), "nihao47", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_bingpin:
                Toast.makeText(getActivity(), "nihao48", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_tanggeng:
                Toast.makeText(getActivity(), "nihao49", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_tangshui:
                Toast.makeText(getActivity(), "nihao50", Toast.LENGTH_LONG).show();
                break;

        }

    }
}
