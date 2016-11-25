package study.funzin.enums;

/**
 * Created by JE on 2016-11-25.
 */
public enum TLVSIDEnum200 {

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
    RECEIVE_DELAY1(200)
    ;

    private final int value;

    TLVSIDEnum200(int value){
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static TLVSIDEnum200 fromInt(int text) {
        for (TLVSIDEnum200 b : TLVSIDEnum200.values()) {
            if (text == b.value) {
                return b;
            }
        }
        return null;
    }

    public static TLVSIDEnum200 fromInt2(int text){

        return null;
    }

}
