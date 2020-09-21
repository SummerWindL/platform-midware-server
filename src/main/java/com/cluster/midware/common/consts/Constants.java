package com.cluster.midware.common.consts;

/**
 * @program: middle-server
 * @description: 常量
 * @author: fuyl
 * @create: 2020-06-20 16:28
 **/

public class Constants {

    public static final String DOCTORID = "doctorid";
    public static final String APPOINTDOCTORID = "appointdoctorid";
    public static final String USERID = "userid";
    public static final String SSID = "ssid";
    public static final String CMDTYPE ="update";
    /**
     * PC端医生订阅地址 start
     */
    public static final String QUEUEDOCTORNOTIFY = "/queue_doctor_notify";
    public static final String TOPICDOCTORNOTIFY = "/topic_doctor_notify";
    public static final String CMD2APP = "cmd_42101001";
    public static final String CMD2DOCTOR = "cmd_41101001";
    public static final String CMD2DOCTOR_SS_INSPECTION_DATA_UPDATE="cmd_41102001"; //推PC端监听命令号
    public static final String CMD2DOCTOR_SS_ALERT_INSPECTION_DATA_UPDATE="cmd_41102002"; //推PC端监听命令号
    /**end*/

    /**
     * 居民预约问诊更新 通知
     */
    public static final String SS_DXMSG_UPDATE_001 = "cmd_40102001";

    /**
     * 居民预约消息更新 通知
     */
    public static final String SS_DXMSG_UPDATE_002 = "cmd_40102002";

    /**
     * 医生问诊消息通知
     */
    public static final String CMD_DOCTOR_DXMSG_UPDATE = "cmd_40103001";

    /**
     * 居民检测数据上传通知
     */
    public static final String CMD_SS_INSPECTION_DATA_UPDATE = "cmd_40106001";

    /**
     * 解散房间通知
     */
    public static final String CMD_DISMISS_ROOM = "cmd_40105001";

    /**
     * 居民档案新增/更新
     */
    public static final String CMD_SS_ARCHIVE_UPSERT = "cmd_40101001";

    /**
     * 居民治疗计划新增/更新
     */
    public static final String CMD_SS_GYPLAN_UPSERT = "cmd_40109001";

    /**
     * 居民随访新增/更新
     */
    public static final String CMD_SS_SF_UPSERT = "cmd_40108001";

    /**
     * Mq Destination
     */
    public static final String DESTINATION_SS_DXMSG_UPDATE = "ss_dxmsg_update";
    public static final String DESTINATION_DOCTOR_DXMSG_UPDATE = "doctor_dxmsg_update";
    public static final String DESTINATION_DIS_MISS_ROOM = "dis_miss_room";
    public static final String DESTINATION_SS_INSPECTION_DATA_UPDATE = "ss_inspection_data_update";
    public static final String TCZZ_HIS_GW_DATA_UPSERT = "tczz_his_gw_data_upsert";
    public static final String DESTINATION_SS_ARCHIVE = "ssinfo_update";
    public static final String DESTINATION_SS_GYPLAN = "gy_update";
    public static final String DESTINATION_SS_SF = "sf_update";


    /**
     * PostgreSQL Notify
     */
    public static final int POSTGRES_NOTIFY_SUCCESS = 1;
    public static final int POSTGRES_NOTIFY_FAILURE = 0;
    public static final String POSTGRES_DESTINATION_ALERT_INSPECTION = "alert_notification";
    public static final String POSTGRES_DESTINATION_TEST_INSPECTION = "test_notification";
    public static final String POSTGRES_DESTINATION_SSINFO_INSPECTION = "ssinfo_notification";
    public static final String POSTGRES_DESTINATION_INSPECTION_INSPECTION = "inspection_notification";
    public static final String POSTGRES_DESTINATION_SF_INSPECTION = "sf_notification";
    public static final String POSTGRES_DESTINATION_GY_INSPECTION = "gy_notification";

}
