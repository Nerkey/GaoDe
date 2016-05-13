package com.example.qu.gaode;

/**
 * 20151221 HeroSong 易车行洗车接口
 * 20151224 HeroSong 更新
 */
public class AppConstants {

    //服务器IP地址
    public static final String BASE_IP = "http://114.215.159.154";
    //APP更新地址
    public static final String GetServerUrl = BASE_IP + "/ddycx/apk";
    //易车行服务接口地址前缀
    //public static final String BASE_URL = BASE_IP + "/ddycx/customer/forApp";
   public static final String BASE_URL = "http://114.215.159.154/ddycx/customer/forApp";
//    public static final String BASE_URL = "http://192.168.0.120:8080/ddycx/customer/forApp";
    //易车行图片服务器地址
    public static final String BASE_IMG_URL = BASE_IP + ":8083" + "/platform/fileupload/";
    //洗车服务接口地址前缀
    public static final String XiChe_BASE_URL = "http://114.215.159.154/ddycx/washingcustomers/forApp";
//    public static final String XiChe_BASE_URL = "http://192.168.0.120:8080/ddycx/washingcustomers/forApp";
    //洗车图片地址前缀

    public static final String XiChe_IMG_BASE_URL = "http://114.215.159.154/uploadimages";
//    public static final String XiChe_IMG_BASE_URL = "http://192.168.0.120:8080/uploadimages";

    //洗车轮循图片服务接口地址
    public static final String BANNERIMGS = XiChe_IMG_BASE_URL + "/banner/";
    //洗车商家头像服务接口地址
    public static final String SHOPSHEADIMGS = XiChe_IMG_BASE_URL + "/shopshead/";
    //洗车商家相册服务接口地址
    public static final String SHOPSPICTURES = XiChe_IMG_BASE_URL + "/shopspictures/";
    //洗车用户头像服务接口地址
    public static final String CUSTOMERHEADIMGS = XiChe_IMG_BASE_URL + "/customerhead/";
    //洗车APP各页面列表图片服务接口地址
    public static final String MESSAGEIMGS = XiChe_IMG_BASE_URL + "/message/";
    //投诉建议
    public static final String COMPLAINFORAPP = XiChe_BASE_URL + "/complainForApp";
    //通过关键字查询商家服务接口
    public static final String FINDSHOPSBYCAPACITYFORAPP = XiChe_BASE_URL + "/findShopsByCapacityForApp";
    //选择区服务接口
    public static final String SELECTEAREAFORAPP = XiChe_BASE_URL + "/selecteAreaForApp";
    //查询选择的城市服务接口
    public static final String FINDSELECTEDCITYSFORAPP = XiChe_BASE_URL + "/findSelectedCitysForApp";
    //查询城市服务接口
    public static final String FINDCITYSFORAPP = XiChe_BASE_URL + "/findCitysForApp";
    //查询省服务接口
    public static final String FINDPROVINCEFORAPP = XiChe_BASE_URL + "/findProvinceForApp";
    //查询最新消息服务接口
    public static final String FINDUPCOMINGFORAPP = XiChe_BASE_URL + "/findUpComingForApp";
    //查询最新活动服务接口
    public static final String FINDACTIVITYFORAPP = XiChe_BASE_URL + "/findActivityForApp";
    //查询商家相册服务接口
    public static final String FINDSHOPSPRCTURESFORAPP = XiChe_BASE_URL + "/findShopsPrcturesForApp";
    //通过商家ID查询商家详情
    public static final String FIND_SHOP_BY_ID_FOR_APP = XiChe_BASE_URL + "/findShopByIdForApp";
    //通过商家ID查询商家服务项目服务接口
    public static final String FINDSHOPITEMSBYSHOPIDFORAPP = XiChe_BASE_URL + "/findShopItemsByShopIdForApp";
    //通过商家项目ID查询项目价格服务接口
    public static final String FINDSHOPSPRICEBYKINDID = XiChe_BASE_URL + "/findShopsPriceByKindId";
    //查询商家详情服务接口
    public static final String FINDSHOPSDETAILSFORAPP = XiChe_BASE_URL + "/findShopsDetailsForApp";
    //查询所有商家服务接口
    public static final String SHOPSFORAPP = XiChe_BASE_URL + "/shopsForApp";
    //通过经纬度坐标查询所有商家服务接口
    public static final String FINDALLSHOPSBYLOCATIONFORAPP = XiChe_BASE_URL + "/findAllShopsByLocationForApp";
    //查询用户中心服务接口
    public static final String FINDCUSTOMERZONEFORAPP = XiChe_BASE_URL + "/findCustomerZoneForApp";
    //上传用户头像服务接口
    public static final String UPLOADHEADIMGFORAPP = XiChe_BASE_URL + "/uploadHeadImgForApp";
    //通过关键字查询订单服务接口
    public static final String FINDORDERBYKEYFORAPP = XiChe_BASE_URL + "/findOrderByKeyForApp";
    //洗车叫号, 获取当前等待的人数
    public static final String XC_ORDERQUEUE = XiChe_BASE_URL + "/carsWaitingForService/";
    //查询所有车辆服务接口
    public static final String FINDALLCARFORAPP = XiChe_BASE_URL + "/findAllcarForApp";
    //添加车辆服务接口
    public static final String ADDCARFORAPP = XiChe_BASE_URL + "/addCarForApp";
    //编辑车辆服务接口
    public static final String COMPILECARFORAPP = XiChe_BASE_URL + "/compileCarForApp";
    //通过车辆ID删除车辆服务接口
    public static final String DELVEHICLEBYIDFORAPP = XiChe_BASE_URL + "/delVehicleByIdForApp";
    //通过用户ID查询所有优惠券服务接口
    public static final String FINDALLDISCOUNTCOUPONBYID = XiChe_BASE_URL + "/findAllDiscountCouponById";
    //通过用户ID查询所有系统消息服务接口
    public static final String FINDSYSMESSAGEBYCUSTOMERIDFORAPP = XiChe_BASE_URL + "/findSYSMessageByCustomerIdForApp";
    //统计该用户的系统消息数量服务接口
    public static final String COUNTSYSMESSAGESBYCUSTOMERIDFORAPP = XiChe_BASE_URL + "/countSYSMessagesByCustomerIdForApp";
    //统计该用户未读系统消息数量服务接口
    public static final String COUNTUNREADSYSMESSAGESBYCUSTOMERIDFORAPP = XiChe_BASE_URL + "/countUnReadSYSMessagesByCustomerIdForApp";
    //改变该用户未读系统消息状态服务接口
    public static final String CHANGEUNREADSYSMESSAGESBYCUSTOMERIDFORAPP = XiChe_BASE_URL + "/changeUnReadSYSMessagesByCustomerIdForApp";
    //通过用户ID查询该用户所有可用优惠券的APP服务接口
    public static final String FINDDISCOUNTCOUPONBYIDFORAPP = XiChe_BASE_URL + "/findDiscountCouponByIdForApp";
    //取消订单服务接口
    public static final String ABOLISHORDERFORAPP = XiChe_BASE_URL + "/abolishOrderForApp";
    //将某个订单的服务费用退给客户
    public static final String GETMONEYBACKFORORDERFORAPP = XiChe_BASE_URL + "/getMoneyBackForOrderForApp";
    //删除订单服务接口
    public static final String DELORDERFORAPP = XiChe_BASE_URL + "/delOrderForApp";
    //查询所有订单服务接口
    public static final String FINDALLORDERS = XiChe_BASE_URL + "/findAllOrders";
    //申请退款服务接口
    public static final String REFUNDAPPLYFORAPP = XiChe_BASE_URL + "/refundApplyForApp";
    //创建订单服务接口
    public static final String CREATEORDERFORAPP = XiChe_BASE_URL + "/createOrderForApp";
    //查询订单详情服务接口
    public static final String FINDORDERDETAILSFORAPP = XiChe_BASE_URL + "/findOrderDetailsForApp";
    //统计车辆状态服务接口
    public static final String CARASTATISTICSFORAPP = BASE_URL + "/caraStatisticsForApp";
    //查询车辆状态服务接口
    public static final String CARSTATUSDETAILFORAPP = BASE_URL + "/carStatusDetailForApp";
    //统计油耗状态服务接口
    public static final String OILCONSUMPTIONSTATEMENTFORAPP = BASE_URL + "/oilConsumptionStatementForApp";
    //关于4S店信息服务接口
    public static final String ABOUTFOURSINFOFORAPP = BASE_URL + "/AboutFourSInfoForApp";
    //获取设备上下文的服务接口
    public static final String DEVICECONTEXT = BASE_URL + "/deviceContext";
    //查询洗车轮播图片服务接口
    public static final String FINDBANNERFORAPP = XiChe_BASE_URL + "/findBannerForApp";
    //获取新闻图片服务接口
    public static final String NEWSPICFORAPP = BASE_URL + "/newsPicForApp";
    //获取车辆位置服务接口
    public static final String GETCARLOCATIONFORAPP = BASE_URL + "/getCarLocationForApp";
    //用户登录服务接口
    public static final String USERLOGINFORAPP = BASE_URL + "/userLoginForApp";
    //发送注册校验码到用户手机的服务接口
    public static final String SENDVALIDATECODETOPHONEFORREGISTER = BASE_URL + "/sendValidateCodeToPhoneForRegister";
    //商家注册服务接口
    public static final String REGISTERFORAPP = BASE_URL + "/registerForApp";
    //取回密码服务接口
    public static final String FINDPWDBACKFORAPP = BASE_URL + "/findPwdBackForApp";
    //发送校验码到用户手机的服务接口
    public static final String SENDVALIDATECODETOTELPHONEFORAPP = BASE_URL + "/sendValidateCodeToTelphoneForApp";
    //根据日期获取已预约的时段字符串
    public static final String GET_ORDER_TIME_FOR_APP = XiChe_BASE_URL + "/getordertimeForApp";
    //跳到新闻页面的服务接口
    public static final String NEWSJUMPFORAPP = BASE_URL + "/newsjumpForApp";
    //获取序列号的服务接口
    public static final String SERIALFORAPP = BASE_URL + "/serialForApp";
    //在用车辆的服务接口
    public static final String USEDCARSSEARCHFORAPP = BASE_URL + "/usedCarsSearchForApp";
    //获取用户设备的服务接口
    public static final String CUSTOMERSERVICEFORAPP = BASE_URL + "/customerServiceForApp";
    //用户中心服务接口
    public static final String CUSTOMERZONEFORAPP = BASE_URL + "/customerZoneForApp";
    //编辑电话号码服务接口
    public static final String EDITPHONENUMBERFORAPP = BASE_URL + "/editPhoneNumberForApp";
    //判断电话号码唯一性的服务接口
    public static final String JUDGEPHONENUMBERUNIQUEFORAPP = BASE_URL + "/judgePhoneNumberUniqueForApp";
    //更新密码服务接口
    public static final String UPDATEPASSWORDFORAPP = BASE_URL + "/updatePassWordForApp";
    //查询新闻讯息服务接口
    public static final String FINDNEWSINFOFORAPP = BASE_URL + "/findNewsInfoForApp";
    //统计在用车辆状况的服务接口
    public static final String USEDCARCONDITIONFORAPP = BASE_URL + "/usedCarConditionForApp";
    //消息列表服务接口
    public static final String MESSAGELIST = BASE_URL + "/messageList";
    //查询最新车辆信息的服务接口
    public static final String FINDNEWCARSINFOFORAPP = BASE_URL + "/findNewCarsInfoForApp";
    //查询在用车辆信息的服务接口
    public static final String FINDUSEDCARSINFOFORAPP = BASE_URL + "/findUsedCarsInfoForApp";
    //通知订单成功支付完成的服务接口
    public static final String ORDERPAYFINISHSUCCESSFORAPP = XiChe_BASE_URL + "/orderPayFinishSuccessForApp";
    //支付
    public static final String FINDTIMEMORETHANMINUTES = XiChe_BASE_URL + "/findTimeMoreThanMinutes";
    //获取充值账户信息服务接口
    public static final String RECHARGEACCOUNTINFOFORAPP = BASE_URL + "/rechargeAccountInfoForApp";
    //创建充值记录服务接口
    public static final String RECHARGECREATEFORAPP = BASE_URL + "/rechargeCreateForApp";
    //列出充值历史记录服务接口
    public static final String RECHARGERECORDLISTALLFORAPP = BASE_URL + "/rechargeRecordListAllForApp";
    //成功完成充值业务服务接口
    public static final String RECHARGEFINISHWORKFORAPP = BASE_URL + "/rechargeFinishWorkForApp";
    //车辆地图轨迹服务接口
    public static final String TRACEMAP = BASE_URL + "/traceMap";
    //通过时间搜索车辆轨迹服务接口
    public static final String SEARCHTRACKBYTIMEFORAPP = BASE_URL + "/searchTrackByTimeForApp";
    //统计消息数量服务接口
    public static final String MESSAGECOUNT = BASE_URL + "/messageCount";
    //将开关设置进行保存接口
    public static final String SETTHEMESSAGEDELIVERY=XiChe_BASE_URL+"/setTheMessageDelivery";
    //列出车辆地图轨迹服务接口
    public static final String TRACELIST = BASE_URL + "/traceList";
    //统计客户车辆的里程，油耗，平均油耗，参考油费，平均车速，运行时长等信息接口
    public static final String CAROILSUMMARYFORAPP = BASE_URL + "/carOilSummaryForApp";



    public static final String XMPP_HOST = "192.168.1.110";//服务器ip121.42.30.187
    public static final int XMPP_PORT = 5222;//端口号
    public static final String XMPP_SERVER = "didiwangluo";//服务器名iz28qq4bbwlz
    public static final String XMPP_MARK = "@didiwangluo/Smack";//会话标示iz28qq4bbwlz

    public static final String SPLIT = "卐";//分隔符，将消息属性分开15000009卐67卐text卐你好，我是迪迪商家！卐12-21
    public static final int NOTIFY_ID = 0x90;

//    public static final boolean IS_PAD = false;//true是平板版，false是手机版

}