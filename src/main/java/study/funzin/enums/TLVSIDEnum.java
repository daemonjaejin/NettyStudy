package study.funzin.enums;

/**
 * Created by JE on 2016-11-25.
 */
public enum TLVSIDEnum {

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
    rx_mac_pkt_total_count(101),
    rx_mac_pkt_crc_ok_count(102),
    rx_mac_pkt_crc_bad_count(103),
    rx_mac_pkt_crc_no_count(104),
    tx_mac_pkt_ok_count(105),
    tx_mac_pkt_bad_count(106),
    rx_mac_pkt_okcrc_ratio(111),
    rx_mac_pkt_badcrc_ratio(112),
    rx_mac_pkt_nocrc_ratio(113),
    rx_gwmp_push_ack_ratio(114),
    rx_gwmp_pull_ack_ratio(115),
    tx_gwmp_mac_data_count(120),
    tx_gwmp_push_data_udp_byte(121),
    tx_gwmp_mac_data_payload_byte(122),
    tx_gwmp_push_data_count(123),
    rx_gwmp_push_ack_count(124),
    tx_gwmp_pull_data_count(125),
    rx_gwmp_pull_ack_count(126),
    rx_gwmp_pull_resp_count(127),
    rx_gwmp_pull_resp_udp_byte(128),
    rx_gwmp_mac_data_payload_byte(129),
    RX_Packet_Counts(130),
    RX_Packet_Bytes(131),
    RX_Packet_errors(132),
    RX_Packet_dropped(133),
    TX_Packet_Counts(134),
    TX_Packet_Bytes(135),
    TX_Packet_erros(136),
    TX_Packet_droppted(137),
    lorawan_public(140),
    clsrc(141),
    rssi_offset(142),
    rf_chain_type(143),
    rf_chain(144),
    tx_enable(145),
    GW_rssi(146),
    bandwidth(148),
    datarate(149),
    sync_word_size(150),
    sync_word(151),
    diag_gain(155),
    pa_gain(156),
    dac_gain(157),
    mix_gain(158),
    rf_power(159),
    watchdog_interval(160),
    Server_port_up(161),
    Server_port_down(162),
    keepalive_interval(163),
    statistics_interval(164),
    push_timeout_ms(165),
    forward_crc_valid(166),
    forward_crc_error(167),
    forward_crc_disabled(168),
    RemotePort(169),
    keepalive_Count(170),
    Alarm_Code(171),
    Fault_Code(172),
    Device_Address(173),
    Alarm_Code1_VSWR(174),
    Alarm_Code2_Antenna(175),
    Alarm_Code3_Temper_High(176),
    Alarm_Code4_Temper_Low(177),
    Alarm_Code5_Cpu(178),
    Alarm_Code6_Memory(179),
    Alarm_Code7_Wan(180),
    Alarm_Code8_Wireless(181),
    Alarm_Code9_TxLow(182),
    Alarm_Code10_Jamming(183),
    Alarm_Code11_Gps(184),
    Alarm_Code12_NwsConnection(185),
    Alarm_Code13_GwConnection(186),
    Alarm_Code14_GwAuthentication(187),
    Fault_Code1_ChannelBlock(191),
    RECEIVE_DELAY1(200),
    JOIN_ACCEPT_DELAY1(201),
    MAX_FCNT_GAP(202),
    ADR_ACK_LIMIT(203),
    ADR_ACK_DELAY(204),
    ACK_TIMEOUT(205),
    RECEIVE_DELAY2(206),
    JOIN_ACCEPT_DELAY2(207),
    Beacon_period(209),
    Beacon_reserved(210),
    Beacon_guard(211),
    Beacon_window(212),
    pingNb(213),
    pingPeriod(214),
    pingOffset(215),
    slotLen(216),
    beaconTime(217),
    join_request(230),
    join_accept(231),
    unconfirmed_data_up(232),
    unconfirmed_data_down(233),
    confirmed_data_up(234),
    confirmed_data_down(235),
    push_data(236),
    push_ack(237),
    pull_data(238),
    pull_resp(239),
    pull_ack(240),
    tx_ack(241),
    freq_state(242),
    freq(243),
    res1(245),
    res2(246),
    res3(247),
    res4(248),
    Channel0_OnOff(260),
    Channel1_OnOff(261),
    Channel2_OnOff(262),
    Channel3_OnOff(263),
    Channel4_OnOff(264),
    Channel5_OnOff(265),
    Channel6_OnOff(266),
    Channel7_OnOff(267),

    Channel0_Freq(268),
    Channel1_Freq(269),
    Channel2_Freq(270),
    Channel3_Freq(271),
    Channel4_Freq(272),
    Channel5_Freq(273),
    Channel6_Freq(274),
    Channel7_Freq(275),

    Channel0_Att(276),
    Channel1_Att(277),
    Channel2_Att(278),
    Channel3_Att(279),
    Channel4_Att(280),
    Channel5_Att(281),
    Channel6_Att(282),
    Channel7_Att(283),

    Alarm1_Grade(300),
    Alarm2_Grade(301),
    Alarm3_Grade(302),
    Alarm4_Grade(303),
    Alarm5_Grade(304),
    Alarm6_Grade(305),
    Alarm7_Grade(306),
    Alarm8_Grade(307),
    Alarm9_Grade(308),
    Alarm10_Grade(309),
    Alarm11_Grade(310),
    Alarm12_Grade(311),
    Alarm13_Grade(312),
    Alarm14_Grade(313),
    Alarm15_Grade(314),

    PortSpeed(400),
    PortLinkStatus(401),
    PortDuplex(402),

    LTE_Equip(410),
    Usim_Equip(411),
    MCC(412),
    MNC(413),
    Band(414),
    DL_Earfcn(415),
    RAT(416),
    APN(417),
    RSSI(418),
    RSRP(419),
    RSRQ(420),
    SINR(421),
    CS_ATTACH(422),
    PS_ATTACH(423),
    Registration(424),
    USIM_Number(425),
    Phone_Number(426),
    IMSI(427),
    CELLID(428),
    WanMacAddress(57),
    GW_EUI64(8),

    /**
     * 통계(statistics) 관련 Single TLV code 추가
     * by ganghanna
     */
    Total_Frame			(450),
    Good_Frame			(451),
    Error_Frame			(452),
    No_CRC_Frame		(454),
    Good_Frame_Ratio	(455),
    Error_Frame_Ratio	(456),
    No_CRC_Frame_Ratio	(457),
    Push_Msg_Ratio		(458),
    Pull_Msg_Ratio		(459),
    Pull_Rsp_Msg_Ratio	(460),
    Push_Data			(461),
    Pull_Data			(462),
    Tx_Ack				(463),
    Push_Ack			(464),
    Pull_Ack			(465),
    Pull_Rsp			(466),
    Join_Accept			(468),
    Unconfirm_Data		(469),
    Confirm_Data		(470),
    Join_Request		(471),
    Total_Count			(472),
    Total_Bytes			(473),
    Count				(474),
    Bytes				(475),
    Error_Count			(476),
    Drop_Bytes			(477),
    Packet_Count		(481),
    Packet_Bytes		(482),
    Packet_Errors		(483),
    Packet_Dropped		(484),
    SF7					(485),
    SF8					(486),
    SF9					(487),
    SF10				(488),
    SF11				(489),
    SF12				(490),
    Too_Late			(491),
    Too_Early			(492),
    Collision_Packet	(493),
    Collision_Beacon	(494),
    Invalid_Tx_Freq		(495),
    Invalid_Tx_Power	(496),
    GPS_Unlocked		(497),
    Rssi				(498),
    SNR					(499)
    ;

    private final int value;

    TLVSIDEnum(int value){
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static TLVSIDEnum fromInt(int text) {
        for (TLVSIDEnum b : TLVSIDEnum.values()) {
            if (text == b.value) {
                return b;
            }
        }
        return null;
    }

    public static TLVSIDEnum fromInt2(int text){

        return null;
    }

}