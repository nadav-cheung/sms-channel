package cn.com.nadav.sms.handler.codec.sgip.pdu;

import java.util.List;

/**
 * Represents the content of an SGIP (Short Message Gateway Interface Protocol) submit message.
 * This class extends the AbstractSgipContent and provides specific implementation details
 * for the SGIP submit operation. It serves as the payload for submit messages in the SGIP protocol.
 */
public class SgipSubmitContent extends AbstractSgipContent {

    private String spNumber; // SP的接入号码

    private String chargeNumber; // 付费号码，手机号码前加“86”国别标志；...

    private int userCount; // 接收短消息的手机数量，取值范围1至100

    private List<String> userNumbers; // 接收该短消息的手机号，该字段重复UserCount...

    private String corpId; // 企业代码，取值范围0-99999
    private String serviceType; // 业务代码，由SP定义
    private int feeType; // 计费类型
    private String feeValue; // 收费值，单位为分，由SP定义
    private String givenValue; // 赠送用户的话费，单位为分，由SP定义
    private int agentFlag; // 代收费标志，0：应收；1：实收
    private int morelatetoMTFlag; // 引起MT消息的原因
    private int priority; // 优先级0-9从低到高
    private String expireTime; // 短消息寿命的终止时间
    private String scheduleTime; // 短消息定时发送的时间
    private int reportFlag; // 状态报告标记
    private int tpPid; // GSM协议类型
    private int tpUdhi; // GSM协议类型，仅使用1位，右对齐
    private int messageCoding; // 短消息的编码格式
    private int messageType; // 信息类型
    private int messageLength; // 短消息的长度
    private String messageContent; // 短消息的实际内容
    private String reserve; // 保留，扩展用

    // Getters and setters

    public String getSpNumber() {
        return spNumber;
    }

    public void setSpNumber(String spNumber) {
        this.spNumber = spNumber;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        this.chargeNumber = chargeNumber;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public List<String> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<String> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public String getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(String feeValue) {
        this.feeValue = feeValue;
    }

    public String getGivenValue() {
        return givenValue;
    }

    public void setGivenValue(String givenValue) {
        this.givenValue = givenValue;
    }

    public int getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(int agentFlag) {
        this.agentFlag = agentFlag;
    }

    public int getMorelatetoMTFlag() {
        return morelatetoMTFlag;
    }

    public void setMorelatetoMTFlag(int morelatetoMTFlag) {
        this.morelatetoMTFlag = morelatetoMTFlag;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public int getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(int reportFlag) {
        this.reportFlag = reportFlag;
    }

    public int getTpPid() {
        return tpPid;
    }

    public void setTpPid(int tpPid) {
        this.tpPid = tpPid;
    }

    public int getTpUdhi() {
        return tpUdhi;
    }

    public void setTpUdhi(int tpUdhi) {
        this.tpUdhi = tpUdhi;
    }

    public int getMessageCoding() {
        return messageCoding;
    }

    public void setMessageCoding(int messageCoding) {
        this.messageCoding = messageCoding;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(int messageLength) {
        this.messageLength = messageLength;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}
