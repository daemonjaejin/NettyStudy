package study.funzin.enums;

/**
 * Created by JE on 2016-11-25.
 */
public enum TLVSIDEnum300 {

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
    Channel7_Att(283)

    ;

    private final int value;

    TLVSIDEnum300(int value){
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static TLVSIDEnum300 fromInt(int text) {
        for (TLVSIDEnum300 b : TLVSIDEnum300.values()) {
            if (text == b.value) {
                return b;
            }
        }
        return null;
    }

    public static TLVSIDEnum300 fromInt2(int text){

        return null;
    }

}
