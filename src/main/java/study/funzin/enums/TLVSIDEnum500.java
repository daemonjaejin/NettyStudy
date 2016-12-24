package study.funzin.enums;

/**
 * Created by JE on 2016-11-25.
 */
public enum TLVSIDEnum500 {

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

    TLVSIDEnum500(int value){
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public static TLVSIDEnum500 fromInt(int text) {
        for (TLVSIDEnum500 b : TLVSIDEnum500.values()) {
            if (text == b.value) {
                return b;
            }
        }
        return null;
    }

    public static TLVSIDEnum500 fromInt2(int text){

        return null;
    }

}
