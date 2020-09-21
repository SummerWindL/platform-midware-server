package com.cluster.midware.common.response;


public enum ResponseResult {

    // +++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++基础级别 错误+++++++++++++++++++++++
    // +++++++++++++++++++++++++++++++++++++++++++++++++
    COMMON_ERROR(-100, "基础错误"),
    COMMON_ERROR_EXCEPTION(-101, "异常错误"),
    COMMON_ERROR_UNKNOWN(-102, "未知错误"),
    COMMON_ERROR_INVALID_PARAM(-103, "无效参数"),
    COMMON_ERROR_NULL_POINTER(-104, "空指针"),
    COMMON_ERROR_ALLOC_FAILED(-105, "分配内存错误"),
    COMMON_ERROR_CONVERT_PARAM(-106, "参数类型转换错误"),
    COMMON_ERROR_PARAM_NOT_NULL(-107, "参数不能为空"),

    // ++++++++++++++++++数据库 db+++++++++++++++++++++++
    DB_ERROR(-1000, "数据库错误"),
    DB_ERROR_CONNECT(-1001, "数据库连接错误"),
    DB_ERROR_INSERT(-1002, "数据库插入错误"),
    DB_ERROR_UPDATE(-1003, "数据库更新错误"),
    DB_ERROR_DELETE(-1004, "数据库删除错误"),
    DB_ERROR_QUERY(-1005, "数据库查询错误"),
    DB_ERROR_RECORD_EXIST(-1006, "记录已经存在"),
    DB_ERROR_RECORD_NOTEXIST(-1007, "记录不存在"),
    DB_ERROR_FIELD_IS_NULL(-1008, "数据库存储过程入参为空"),



    // ++++++++++++++++++通讯 错误+++++++++++++++++++++++
    COMM_ERROR(-2000, "通讯错误"),
    COMM_ERROR_LISTEN(-2001, "Listen错误"),
    COMM_ERROR_ACCEPT(-2002, "Accept错误"),
    COMM_ERROR_CONNECT(-2003, "Connect错误"),
    COMM_ERROR_RECV(-2004, "RECV错误"),
    COMM_ERROR_SEND(-2005, "SEND错误"),
    COMM_ERROR_PORT_USED(-2006, "端口占用错误"),

    // ++++++++++++++++++IO 错误+++++++++++++++++++++++
    IO_ERROR(-3000, "IO错误"),
    IO_ERROR_FILE_NOT_EXIST(-3001, "文件不存在"),
    IO_ERROR_CREATE(-3002, "创建失败"),
    IO_ERROR_OPEN(-3003, "打开失败"),
    IO_ERROR_WRITE(-3004, "写失败"),
    IO_ERROR_READ(-3005, "读失败"),
    IO_ERROR_CLOSE(-3005, "关闭失败"),

    // ++++++++++++++++++HTTP 通讯协议错误+++++++++++++++++++++++
    HTTP_ERROR(-4000, "HTTP错误"),
    HTTP_ERROR_INVALID_REQUEST(-4001, "请求命令无效"),
    HTTP_ERROR_INVALID_PARAM(-4002, "参数不正确"),
    HTTP_ERROR_INVALID_SIGN(-4003, "签名无效"),
    HTTP_ERROR_POST_FAILURE(-4004, "POST请求失败"),
    HTTP_ERROR_PARSE_JSON(-4005, "JSON格式解析失败"),
    HTTP_ERROR_REQUEST_INTERCEPTOR(-4006, "请求被拦截"),
    HTTP_ERROR_UNSURPORT_PROTO_VER(-4007, "不支持的协议版本"),
    HTTP_ERROR_URL_ENCODE_ERROR(-4008, "URL编码错误"),
    HTTP_ERROR_WRITE_JSON(-4009, "生成JSON失败"),

    // ++++++++++++++++++HTTP 通讯协议上传文件错误+++++++++++++++++++++++
    HTTP_ERROR_UPLOAD_FILE_EMPTY(-5000, "上传文件为空"),
    HTTP_ERROR_UPLOAD_FILE_FAILURE(-5001, "上传文件失败"),

    // ++++++++++++++++++Excel文件操作错误+++++++++++++++++++++++
    EXCEL_ERROR_CREATE(-6000, "创建失败"),
    EXCEL_ERROR_OPEN(-6001, "打开失败"),
    EXCEL_ERROR_WRITE(-6002, "写失败"),
    EXCEL_ERROR_READ(-6003, "读失败"),
    EXCEL_ERROR_CLOSE(-6004, "关闭失败"),
    EXCEL_ERROR_COLUMN_HEADER_ISEMPTY(-6005, "表头字段为空"),

    // +++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++业务级别 错误+++++++++++++++++++++++
    // +++++++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++错误+++++++++++++++++++++++
    BIZ_ERROR_INVALID_PARAM(-10001, "参数不正确"),
    BIZ_ERROR_TYPE_NOT_SUPPORT(-10002, "不支持的分类类型"),
    BIZ_ERROR_CHECKCODE(-10003, "验证码错误"),
    BIZ_ERROR_SEND_CHECKCODE(-10004, "发送验证码错误"),
    BIZ_ERROR_TOKEN_INVALID(-10005, "token无效"),
    BIZ_ERROR_DBJSON2CLZ(-10006, "数据库结果JSON转换实体类错误"),
    BIZ_ERROR_IMCFG_ERROR(-10006, "开通医生IM账号错误：IM参数配置不可为空！"),


    // ++++++++++++++++++成功+++++++++++++++++++++++
    ZX_SUCCESS(0, "成功"),
    COMMON_SUCCESS(0, "成功");


    private int resultcode;

    private String resultmsg;

    private ResponseResult(int resultcode, String resultmsg) {
        this.resultcode = resultcode;
        this.resultmsg = resultmsg;
    }

    public int getResultcode() {
        return resultcode;
    }

    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    public String getResultmsg() {
        return resultmsg;
    }

    public void setResultmsg(String resultmsg) {
        this.resultmsg = resultmsg;
    }
}
