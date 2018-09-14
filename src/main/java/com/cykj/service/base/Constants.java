package com.cykj.service.base;

import com.cykj.service.entity.Weather;
import com.cykj.service.entity.WeatherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 16:35.
 */
public class Constants {

    public static List<String> accountCode = new ArrayList<String>();
    public static List<String> goodInfoCode = new ArrayList<String>();
    public static List<WeatherInfo> WEATHER_LIST = new ArrayList<>();

    public static final String CURRENT_USER = "user";
    public static final String TOTALS = "total";
    public static final String ROWS = "rows";

    public static Map<String,String> LOCAL_MAP = new HashMap<>();
    static {
        //成都
        LOCAL_MAP.put("市辖区","chengdu");
        LOCAL_MAP.put("锦江区","chengdu");
        LOCAL_MAP.put("青羊区","chengdu");
        LOCAL_MAP.put("金牛区","chengdu");
        LOCAL_MAP.put("武侯区","chengdu");
        LOCAL_MAP.put("成华区","chengdu");
        LOCAL_MAP.put("龙泉驿区","longquanyi");
        LOCAL_MAP.put("青白江区","chengdu");
        LOCAL_MAP.put("新都区","xindu");
        LOCAL_MAP.put("温江区","wenjiang");
        LOCAL_MAP.put("双流区","shuangliu");
        LOCAL_MAP.put("大邑县","dayi");
        LOCAL_MAP.put("浦江县","pujiang");
        LOCAL_MAP.put("都江堰市","dujiangyan");
        LOCAL_MAP.put("郫县","pixian");
        LOCAL_MAP.put("金堂县","jintang");
        LOCAL_MAP.put("新津","xinjin");
        LOCAL_MAP.put("彭州市","pengzhou");
        LOCAL_MAP.put("邛崃市","qionglai");
        LOCAL_MAP.put("崇州市","chongzhou");
        LOCAL_MAP.put("简阳市","jianyang");

        //自贡
        LOCAL_MAP.put("自流井区","zigong");
        LOCAL_MAP.put("贡井区","zigong");
        LOCAL_MAP.put("大安区","zigong");
        LOCAL_MAP.put("沿滩区","zigong");
        LOCAL_MAP.put("荣县","rongxian");
        LOCAL_MAP.put("富顺县","fushun");

        //攀枝花市
        LOCAL_MAP.put("东区","panzhihua");
        LOCAL_MAP.put("西区","panzhihua");
        LOCAL_MAP.put("仁和区","panzhihua");
        LOCAL_MAP.put("米易县","miyi");
        LOCAL_MAP.put("盐边县","yanbian");

        //泸州市
        LOCAL_MAP.put("江阳区","luzhou");
        LOCAL_MAP.put("纳溪区","luzhou");
        LOCAL_MAP.put("龙马潭区","luzhou");
        LOCAL_MAP.put("泸县","luxian");
        LOCAL_MAP.put("合江县","hejiang");
        LOCAL_MAP.put("叙永县","xuyong");
        LOCAL_MAP.put("古蔺县","gulin");

        //德阳市
        LOCAL_MAP.put("旌阳区","deyang");
        LOCAL_MAP.put("广汉市","guanghan");
        LOCAL_MAP.put("什邡市","shifang");
        LOCAL_MAP.put("绵竹市","mianzhu");
        LOCAL_MAP.put("中江县","zhongjiang");
        LOCAL_MAP.put("罗江县","luojiang");

        //绵阳市
        LOCAL_MAP.put("涪城区","mianyang");
        LOCAL_MAP.put("游仙区","mianyang");
        LOCAL_MAP.put("安州区","mianyang");
        LOCAL_MAP.put("江油市","jiangyou");
        LOCAL_MAP.put("三台县","santai");
        LOCAL_MAP.put("盐亭县","yanting");
        LOCAL_MAP.put("梓潼县","zitong");
        LOCAL_MAP.put("平武县","pingwu");
        LOCAL_MAP.put("北川羌族自治县","beichuan");

        //广元市
        LOCAL_MAP.put("利州区","lizhou");
        LOCAL_MAP.put("昭化区","zhaohua");
        LOCAL_MAP.put("朝天区","chaotian");
        LOCAL_MAP.put("旺苍县","wangcang");
        LOCAL_MAP.put("青川县","qingchuan");
        LOCAL_MAP.put("剑阁县","jiange");
        LOCAL_MAP.put("苍溪县","cangxi");

        //遂宁市
        LOCAL_MAP.put("船山区","suining");
        LOCAL_MAP.put("安居区","suining");
        LOCAL_MAP.put("蓬溪县","pengxi");
        LOCAL_MAP.put("射洪县","shehong");
        LOCAL_MAP.put("大英县","daying");

        //内江市
        LOCAL_MAP.put("市中区","neijiang");
        LOCAL_MAP.put("东兴区","neijiang");
        LOCAL_MAP.put("威远县","weiyuan");
        LOCAL_MAP.put("资中县","zizhong");
        LOCAL_MAP.put("隆昌县","longchang");

        //乐山市
        LOCAL_MAP.put("市中区","leshan");
        LOCAL_MAP.put("沙湾区","leshan");
        LOCAL_MAP.put("五通桥区","leshan");
        LOCAL_MAP.put("金口河区","leshan");
        LOCAL_MAP.put("峨眉山市","emeishan");
        LOCAL_MAP.put("犍为县","jianwei");
        LOCAL_MAP.put("井研县","jinyan");
        LOCAL_MAP.put("夹江县","jiajiang");
        LOCAL_MAP.put("沐川县","muchuan");
        LOCAL_MAP.put("峨边彝族自治县","ebian");
        LOCAL_MAP.put("马边彝族自治县","mabian");

        //南充市
        LOCAL_MAP.put("顺庆区","nanchong");
        LOCAL_MAP.put("高坪区","nanchong");
        LOCAL_MAP.put("嘉陵区","nanchong");
        LOCAL_MAP.put("阆中市","langzhong");
        LOCAL_MAP.put("南部县","nanbu");
        LOCAL_MAP.put("营山县","yingshan");
        LOCAL_MAP.put("蓬安县","pengan");
        LOCAL_MAP.put("仪陇县","yilong");
        LOCAL_MAP.put("西充县","xichong");

        //眉山市
        LOCAL_MAP.put("东坡区","dongpo");
        LOCAL_MAP.put("彭山区","pengshan");
        LOCAL_MAP.put("仁寿县","renshou");
        LOCAL_MAP.put("洪雅县","hongya");
        LOCAL_MAP.put("丹棱县","danleng");
        LOCAL_MAP.put("青神县","qingshen");

        //宜宾市
        LOCAL_MAP.put("翠屏区","yibin");
        LOCAL_MAP.put("南溪区","yibin");
        LOCAL_MAP.put("宜宾县","yibinxian");
        LOCAL_MAP.put("江安县","jiangan");
        LOCAL_MAP.put("长宁县","changning");
        LOCAL_MAP.put("高县","gaoxian");
        LOCAL_MAP.put("珙县","gongxian");
        LOCAL_MAP.put("筠连县","yunlian");
        LOCAL_MAP.put("兴文县","xingwen");
        LOCAL_MAP.put("屏山县","pingshan");

        //广安市
        LOCAL_MAP.put("广安区","guangan");
        LOCAL_MAP.put("前锋区","guangan");
        LOCAL_MAP.put("华蓥市","huaying");
        LOCAL_MAP.put("岳池县","yuechi");
        LOCAL_MAP.put("武胜县","wusheng");
        LOCAL_MAP.put("邻水县","linshui");

        //达州市
        LOCAL_MAP.put("通川区","dazhou");
        LOCAL_MAP.put("达川区","dazhou");
        LOCAL_MAP.put("万源市","wanyuan");
        LOCAL_MAP.put("宣汉县","xuanhan");
        LOCAL_MAP.put("开江县","kaijiang");
        LOCAL_MAP.put("大竹县","dazhu");
        LOCAL_MAP.put("渠县","quxian");

        //雅安市
        LOCAL_MAP.put("雨城区","yaan");
        LOCAL_MAP.put("名山区","yaan");
        LOCAL_MAP.put("荥经县","yingjing");
        LOCAL_MAP.put("汉源县","hanyuan");
        LOCAL_MAP.put("石棉县","shimian");
        LOCAL_MAP.put("天全县","tianquan");
        LOCAL_MAP.put("芦山县","lushan");
        LOCAL_MAP.put("宝兴县","baoxing");

        //巴中市
        LOCAL_MAP.put("巴州区","bazhong");
        LOCAL_MAP.put("恩阳区","bazhong");
        LOCAL_MAP.put("通江县","tongjiang");
        LOCAL_MAP.put("南江县","nanjiang");
        LOCAL_MAP.put("平昌县","pingchang");

        //资阳市
        LOCAL_MAP.put("雁江区","ziyang");
        LOCAL_MAP.put("安岳县","anyue");
        LOCAL_MAP.put("乐至县","lezhi");

        //阿坝藏族羌族自治州
        LOCAL_MAP.put("马尔康市","maerkang");
        LOCAL_MAP.put("汶川县","wenchuan");
        LOCAL_MAP.put("理县","lixian");
        LOCAL_MAP.put("茂县","maoxian");
        LOCAL_MAP.put("松潘县","songpan");
        LOCAL_MAP.put("九寨沟县","jiuzaigou");
        LOCAL_MAP.put("金川县","jinchuan");
        LOCAL_MAP.put("小金县","xiaojin");
        LOCAL_MAP.put("黑水县","heishui");
        LOCAL_MAP.put("壤塘县","xiangtang");
        LOCAL_MAP.put("阿坝县","aba");
        LOCAL_MAP.put("若尔盖县","ruoergai");
        LOCAL_MAP.put("红原县","hongyuan");

        //甘孜藏族自治州
        LOCAL_MAP.put("康定市","kangding");
        LOCAL_MAP.put("泸定县","luxian");
        LOCAL_MAP.put("丹巴县","danba");
        LOCAL_MAP.put("九龙县","jiulong");
        LOCAL_MAP.put("雅江县","yajiang");
        LOCAL_MAP.put("道孚县","daofu");
        LOCAL_MAP.put("炉霍县","luhuo");
        LOCAL_MAP.put("甘孜县","ganzi");
        LOCAL_MAP.put("新龙县","xinlong");
        LOCAL_MAP.put("德格县","dege");
        LOCAL_MAP.put("白玉县","baiyu");
        LOCAL_MAP.put("石渠县","shiqu");
        LOCAL_MAP.put("色达县","seda");
        LOCAL_MAP.put("理塘县","litang");
        LOCAL_MAP.put("巴塘县","batang");
        LOCAL_MAP.put("乡城县","xiangcheng");
        LOCAL_MAP.put("稻城县","daocheng");
        LOCAL_MAP.put("得荣县","derong");

        //凉山彝族自治州
        LOCAL_MAP.put("西昌市","xichang");
        LOCAL_MAP.put("木里藏族自治县","muli");
        LOCAL_MAP.put("盐源县","yanyuan");
        LOCAL_MAP.put("德昌县","dechang");
        LOCAL_MAP.put("会理县","huili");
        LOCAL_MAP.put("会东县","huidong");
        LOCAL_MAP.put("宁南县","ningnan");
        LOCAL_MAP.put("普格县","puge");
        LOCAL_MAP.put("布拖县","butuo");
        LOCAL_MAP.put("金阳县","jinyang");
        LOCAL_MAP.put("昭觉县","zhaojue");
        LOCAL_MAP.put("喜德县","xide");
        LOCAL_MAP.put("冕宁县","mianning");
        LOCAL_MAP.put("越西县","yuexi");
        LOCAL_MAP.put("甘洛县","ganluo");
        LOCAL_MAP.put("美姑县","meigu");
        LOCAL_MAP.put("雷波县","leibo");

    }

    public static void addWether(WeatherInfo weather){
        WEATHER_LIST.add(weather);
    }

}
