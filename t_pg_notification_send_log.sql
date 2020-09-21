-- 创建日志表脚本
CREATE TABLE t_pg_notification_send_log (
	serialid varchar(64) NOT NULL,
	commercianunit varchar(64) NULL,
	destination varchar(64) NULL,
	params jsonb NULL,
	createdtime timestamp NULL,
	CONSTRAINT pk_t_pg_notification_send_log PRIMARY KEY (serialid)
);