package study.funzin.main4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JE on 2017-02-03.
 */
public class SelectionMain {

    public static void main(String [] args){

        SelectionMain sm = new SelectionMain();
//        sm.headerList();
        sm.combine();
    }

    public void headerList(){

        Map<String, String> map = new HashMap<String, String>();

        map.put("test", "test");
        map.put("test2", "test2");
        map.put("test3", "test3");

        Map<Integer, Object> resultMap = new HashMap<Integer, Object>();

        resultMap.put(1, map);

        System.out.println("size : " + map.size());

    }

    public void combine(){
        String headerStr = "gwid,serialNo,gatewayNm,lorawan_public,clksrc,rfChani0_enable,rfChain0_Freq_off,rfChain0_rssi_offset,rfChain0_rf_chain_type,rfChain0_tx_enable,rfChani1_enable,rfChain1_Freq_off"
                + ",rfChain1_rssi_offset,rfChain1_rf_chain_type,rfChain1_tx_enable,modemChain0_enable,modemChain0_rf_chain,modemChain0_Freq_off,modemChain0_bandwidth,modemChain0_datarate"
                + ",modemChain0_sync_word_size,modemChain0_sync_word,modemChain1_enable,modemChain1_rf_chain,modemChain1_Freq_off,modemChain1_bandwidth,modemChain1_datarate,modemChain1_sync_word_size"
                + ",modemChain1_sync_word,modemChain2_enable,modemChain2_rf_chain,modemChain2_Freq_off,modemChain2_bandwidth,modemChain2_datarate,modemChain2_sync_word_size,modemChain2_sync_word"
                + ",modemChain3_enable,modemChain3_rf_chain,modemChain3_Freq_off,modemChain3_bandwidth,modemChain3_datarate,modemChain3_sync_word_size,modemChain3_sync_word,modemChain4_enable"
                + ",modemChain4_rf_chain,modemChain4_Freq_off,modemChain4_bandwidth,modemChain4_datarate,modemChain4_sync_word_size,modemChain4_sync_word,modemChain5_enable,modemChain5_rf_chain,modemChain5_Freq_off"
                + ",modemChain5_bandwidth,modemChain5_datarate,modemChain5_sync_word_size,modemChain5_sync_word,modemChain6_enable,modemChain6_rf_chain,modemChain6_Freq_off,modemChain6_bandwidth,modemChain6_datarate"
                + ",modemChain6_sync_word_size,modemChain6_sync_word,modemChain7_enable,modemChain7_rf_chain,modemChain7_Freq_off,modemChain7_bandwidth,modemChain7_datarate,modemChain7_sync_word_size"
                + ",modemChain7_sync_word,loraChain_enable,loraChain_rf_chain,loraChain_Freq_off,loraChain_bandwidth,loraChain_datarate,loraChain_sync_word_size,loraChain_sync_word,fskChain_enable,fskChain_rf_chain,fskChain_Freq_off"
                + ",fskChain_bandwidth,fskChain_datarate,fskChain_sync_word_size,fskChain_sync_word,txGain0_diag_gain,txGain0_pa_gain,txGain0_dac_gain,txGain0_mix_gain,txGain0_rf_power,txGain1_diag_gain,txGain1_pa_gain"
                + ",txGain1_dac_gain,txGain1_mix_gain,txGain1_rf_power,txGain2_diag_gain,txGain2_pa_gain,txGain2_dac_gain,txGain2_mix_gain,txGain2_rf_power,txGain3_diag_gain,txGain3_pa_gain,txGain3_dac_gain,txGain3_mix_gain"
                + ",txGain3_rf_power,txGain4_diag_gain,txGain4_pa_gain,txGain4_dac_gain,txGain4_mix_gain,txGain4_rf_power,txGain5_diag_gain,txGain5_pa_gain,txGain5_dac_gain,txGain5_mix_gain,txGain5_rf_power,txGain6_diag_gain"
                + ",txGain6_pa_gain,txGain6_dac_gain,txGain6_mix_gain,txGain6_rf_power,txGain7_diag_gain,txGain7_pa_gain,txGain7_dac_gain,txGain7_mix_gain,txGain7_rf_power,txGain8_diag_gain,txGain8_pa_gain,txGain8_dac_gain"
                + ",txGain8_mix_gain,txGain8_rf_power,txGain9_diag_gain,txGain9_pa_gain,txGain9_dac_gain,txGain9_mix_gain,txGain9_rf_power,txGain10_diag_gain,txGain10_pa_gain,txGain10_dac_gain,txGain10_mix_gain,txGain10_rf_power"
                + ",txGain11_diag_gain,txGain11_pa_gain,txGain11_dac_gain,txGain11_mix_gain,txGain11_rf_power,txGain12_diag_gain,txGain12_pa_gain,txGain12_dac_gain,txGain12_mix_gain,txGain12_rf_power,txGain13_diag_gain"
                + ",txGain13_pa_gain,txGain13_dac_gain,txGain13_mix_gain,txGain13_rf_power,txGain14_diag_gain,txGain14_pa_gain,txGain14_dac_gain,txGain14_mix_gain,txGain14_rf_power,txGain15_diag_gain,txGain15_pa_gain"
                + ",txGain15_dac_gain,txGain15_mix_gain,txGain15_rf_power,EUI64,nws_primary_IpVersion,nws_primary_Ipv4Address,nws_primary_Ipv6Address,nws_primary_Server_port_up,nws_primary_Server_port_down,nws_secondary_IpVersion"
                + ",nws_secondary_Ipv4Address,nws_secondary_Ipv6Address,nws_secondary_Server_port_up,nws_secondary_Server_port_down,keepalive_interval,statistics_interval,keepalive_count,push_timeout_ms,forward_crc_valid,forward_crc_error"
                + ",forward_crc_disabled,Channel0_Block,Channel1_Block,Channel2_Block,Channel3_Block,Channel4_Block,Channel5_Block,Channel6_Block,Channel7_Block,Channel0_Freq,Channel1_Freq,Channel2_Freq,Channel3_Freq,Channel4_Freq"
                + ",Channel5_Freq,Channel6_Freq,Channel7_Freq,Channel0_Pwr,Channel1_Pwr,Channel2_Pwr,Channel3_Pwr,Channel4_Pwr,Channel5_Pwr,Channel6_Pwr,Channel7_Pwr,BackhaulSwitch,NWSBackhaulSwitch,BackhaulSwitchCondition"
                + ",lbt_threshhold,jam_threshhold,vswr_threshhold,vswr_check,Alarm_Code1_VSWR_critical,Alarm_Code1_VSWR_major,Alarm_Code1_VSWR_minor,Alarm_Code1_VSWR_normal,Alarm_Code2_Antenna_critical,Alarm_Code2_Antenna_major"
                + ",Alarm_Code2_Antenna_minor,Alarm_Code2_Antenna_normal,Alarm_Code3_Temper_High_critical,Alarm_Code3_Temper_High_major,Alarm_Code3_Temper_High_minor,Alarm_Code3_Temper_High_normal"
                + ",Alarm_Code4_Temper_Low_critical,Alarm_Code4_Temper_Low_major,Alarm_Code4_Temper_Low_minor,Alarm_Code4_Temper_Low_normal,Alarm_Code5_Cpu_critical,Alarm_Code5_Cpu_major,Alarm_Code5_Cpu_minor"
                + ",Alarm_Code5_Cpu_normal,Alarm_Code6_Memory_critical,Alarm_Code6_Memory_major,Alarm_Code6_Memory_minor,Alarm_Code6_Memory_normal,Alarm_Code7_Wan_critical,Alarm_Code7_Wan_major,Alarm_Code7_Wan_minor"
                + ",Alarm_Code7_Wan_normal,Alarm_Code8_Wireless_critical,Alarm_Code8_Wireless_major,Alarm_Code8_Wireless_minor,Alarm_Code8_Wireless_normal,Alarm_Code9_TxLow_critical,Alarm_Code9_TxLow_major,Alarm_Code9_TxLow_minor"
                + ",Alarm_Code9_TxLow_normal,Alarm_Code10_Jamming_critical,Alarm_Code10_Jamming_major,Alarm_Code10_Jamming_minor,Alarm_Code10_Jamming_normal,Alarm_Code11_Gps_critical,Alarm_Code11_Gps_major"
                + ",Alarm_Code11_Gps_minor,Alarm_Code11_Gps_normal,Alarm_Code12_NwsConnection_critical,Alarm_Code12_NwsConnection_major,Alarm_Code12_NwsConnection_minor,Alarm_Code12_NwsConnection_normal"
                + ",Alarm_Code13_GwConnection_critical,Alarm_Code13_GwConnection_major,Alarm_Code13_GwConnection_minor,Alarm_Code13_GwConnection_normal,Alarm_Code14_GwAuthentication_critical,Alarm_Code14_GwAuthentication_major"
                + ",Alarm_Code14_GwAuthentication_minor,Alarm_Code14_GwAuthentication_normal,Alarm_Code15_DyingGaps_critical,Alarm_Code15_DyingGaps_major,Alarm_Code15_DyingGaps_minor,Alarm_Code15_DyingGaps_normal"
                + ",gw_IpVersion,gw_Ipv4Address,gw_Ipv6Address,gw_IpAssignType,gw_IpPrefix,gw_GateWayIpv4Address,gw_GateWayIpv6Address,gw_NetMaskIpv4Address,LoRaMacClass0,LoRaMacClass1,LoRaMacClass2,RECEIVE_DELAY1"
                + ",RECEIVE_DELAY2,JOIN_ACCEPT_DELAY1,JOIN_ACCEPT_DELAY2,MAX_FCNT_GAP,ADR_ACK_LIMIT,ADR_ACK_DELAY,ACK_TIMEOUT,Beacon_period,Beacon_reserved,Beacon_guard,Beacon_window,pingNb,pingPeriod,pingOffset"
                + ",beaconTime,slotLen,keepalive_interval,statistics_interval,watchdog_interval,Remote_SSH_Set_enable,Remote_SSH_Set_RemotePort,Remote_HTTP_Set_enable,Remote_HTTP_Set_RemotePort,Remote_HTTPS_Set_enable"
                + ",Remote_HTTPS_Set_RemotePort,SchedulelingType"
                + ",ip_address,wan_mac_address,gw_eui64,mdn,imsi,cellid,usimIccid,rat,band_data,dl_earfcn,rsrp,rsrq,rssi,sinr,gemsId";

        String [] arr = headerStr.split(",");
        System.out.println("arr.length : " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "insert into `oss_cm_collection` (col_name, ordering, use_yn, del_yn, ins_date_time) values ('" + arr[i] + "', " + (i) + ", 1, 0, now());";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
