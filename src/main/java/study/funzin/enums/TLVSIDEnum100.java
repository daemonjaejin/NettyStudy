package study.funzin.enums;

/**
 * Created by JE on 2016-11-25.
 */
public enum TLVSIDEnum100 {

    SerialNumber(1),
    SWVersion(2),
    Type(3),
    Gateway_ID(4),
    Result(5),
    EMS_ID(6),
    NEXT_EMS_ID(7),
    //	EMS_IP(8),
//	NWS_EUI64(8),
    EUI64(9),
    FTPUserID(10),
    FTPUserPass(11),
    FTPUserURL(12),
    FileName(13),
    FileSize(14),
    LoadingTime(15),
    DefaultPldReq(16),
    BuildTime(17),
    Number(18),
    enable(19),
    Freq_off(20),
    ChannelAtt(21),
    BackhaulSwitch(22),
    BackhaulSwitchCondition(23),
    NWBackhaulSwitch(24),
    PPPoE_Auth(25),
    GW_PowerType(26),
    lbt_threshold(31),
    //DutyValue(32),
    vswr_threshhold(32),
    jam_threshold(33),
    //AlarmType(34),
    SchedulelingType(34),
    Alarm_Grade(35),
    AlarmStatus(36),
    AlarmThreshold(37),
    AlarmThresholdMax(38),
    vswr_check(39),
    TSSI(40),
    IpVersion(44),
    Ipv4Address(45),
    Ipv6Address(46),
    IpPrefix(47),
    IpAssignType(48),
    NetMaskIpv4Address(49),
    NetMaskIpv6Address(50),
    GateWayIpv4Address(51),
    GateWayIpv6Address(52),
    SeverType(53),
    RebootReson(54),
    GatewayType(55),
    LoRaMacClass(56),
    ResourcesType(81),
    CPUStatus(82),
    MemoryStatus(83),
    GPSStatus(84),
    LTEStatus(85),
    TemperatureStatus(86),
    IntervalStatus(87),
    Manufacturer(91),
    HWVersion(92),
    ProductionDate(93),
    InstallationDate(94),
    GPS_Latitude(95),
    GPS_Longitude(96),
    ActiveBackhaul(97),
    ActiveNWSBackhaul(98),
    WanMacAddress(57),
    GW_EUI64(8)
    ;

    private final int value;

    TLVSIDEnum100(int value){
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static TLVSIDEnum100 fromInt(int text) {
        for (TLVSIDEnum100 b : TLVSIDEnum100.values()) {
            if (text == b.value) {
                return b;
            }
        }
        return null;
    }

    public static TLVSIDEnum100 fromInt2(int text){

        return null;
    }

}
