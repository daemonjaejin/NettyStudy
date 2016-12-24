package study.funzin.main;

/**
 * Created by JE on 2016-11-25.
 */
public class ArrayMain {

    public static void main(String [] args){
        String [] csvLine = new String[100];
        for (int i = 0; i < csvLine.length; i++) {
            if(csvLine[i] == null){
                csvLine[i] = "";
            }
            System.out.println(i + " : " + csvLine[i]);
        }
        String str = "gwid\tserialNo\tgatewayNm\tlorawan_public\tclksrc\trfChani0_enable\trfChain0_Freq_off\trfChain0_rssi_offset\trfChain0_rf_chain_type\trfChain0_tx_enable\trfChani1_enable\trfChain1_Freq_off\trfChain1_rssi_offset\trfChain1_rf_chain_type\trfChain1_tx_enable\tmodemChain0_enable\tmodemChain0_rf_chain\tmodemChain0_Freq_off\tmodemChain0_bandwidth\tmodemChain0_datarate\tmodemChain0_sync_word_size\tmodemChain0_sync_word\tmodemChain1_enable\tmodemChain1_rf_chain\tmodemChain1_Freq_off\tmodemChain1_bandwidth\tmodemChain1_datarate\tmodemChain1_sync_word_size\tmodemChain1_sync_word\tmodemChain2_enable\tmodemChain2_rf_chain\tmodemChain2_Freq_off\tmodemChain2_bandwidth\tmodemChain2_datarate\tmodemChain2_sync_word_size\tmodemChain2_sync_word\tmodemChain3_enable\tmodemChain3_rf_chain\tmodemChain3_Freq_off\tmodemChain3_bandwidth\tmodemChain3_datarate\tmodemChain3_sync_word_size\tmodemChain3_sync_word\tmodemChain4_enable\tmodemChain4_rf_chain\tmodemChain4_Freq_off\tmodemChain4_bandwidth\tmodemChain4_datarate\tmodemChain4_sync_word_size\tmodemChain4_sync_word\tmodemChain5_enable\tmodemChain5_rf_chain\tmodemChain5_Freq_off\tmodemChain5_bandwidth\tmodemChain5_datarate\tmodemChain5_sync_word_size\tmodemChain5_sync_word\tmodemChain6_enable\tmodemChain6_rf_chain\tmodemChain6_Freq_off\tmodemChain6_bandwidth\tmodemChain6_datarate\tmodemChain6_sync_word_size\tmodemChain6_sync_word\tmodemChain7_enable\tmodemChain7_rf_chain\tmodemChain7_Freq_off\tmodemChain7_bandwidth\tmodemChain7_datarate\tmodemChain7_sync_word_size\tmodemChain7_sync_word\tloraChain_enable\tloraChain_rf_chain\tloraChain_Freq_off\tloraChain_bandwidth\tloraChain_datarate\tloraChain_sync_word_size\tloraChain_sync_word\tfskChain_enable\tfskChain_rf_chain\tfskChain_Freq_off\tfskChain_bandwidth\tfskChain_datarate\tfskChain_sync_word_size\tfskChain_sync_word\ttxGain0_diag_gain\ttxGain0_pa_gain\ttxGain0_dac_gain\ttxGain0_mix_gain\ttxGain0_rf_power\ttxGain1_diag_gain\ttxGain1_pa_gain\ttxGain1_dac_gain\ttxGain1_mix_gain\ttxGain1_rf_power\ttxGain2_diag_gain\ttxGain2_pa_gain\ttxGain2_dac_gain\ttxGain2_mix_gain\ttxGain2_rf_power\ttxGain3_diag_gain\ttxGain3_pa_gain\ttxGain3_dac_gain\ttxGain3_mix_gain\ttxGain3_rf_power\ttxGain4_diag_gain\ttxGain4_pa_gain\ttxGain4_dac_gain\ttxGain4_mix_gain\ttxGain4_rf_power\ttxGain5_diag_gain\ttxGain5_pa_gain\ttxGain5_dac_gain\ttxGain5_mix_gain\ttxGain5_rf_power\ttxGain6_diag_gain\ttxGain6_pa_gain\ttxGain6_dac_gain\ttxGain6_mix_gain\ttxGain6_rf_power\ttxGain7_diag_gain\ttxGain7_pa_gain\ttxGain7_dac_gain\ttxGain7_mix_gain\ttxGain7_rf_power\ttxGain8_diag_gain\ttxGain8_pa_gain\ttxGain8_dac_gain\ttxGain8_mix_gain\ttxGain8_rf_power\ttxGain9_diag_gain\ttxGain9_pa_gain\ttxGain9_dac_gain\ttxGain9_mix_gain\ttxGain9_rf_power\ttxGain10_diag_gain\ttxGain10_pa_gain\ttxGain10_dac_gain\ttxGain10_mix_gain\ttxGain10_rf_power\ttxGain11_diag_gain\ttxGain11_pa_gain\ttxGain11_dac_gain\ttxGain11_mix_gain\ttxGain11_rf_power\ttxGain12_diag_gain\ttxGain12_pa_gain\ttxGain12_dac_gain\ttxGain12_mix_gain\ttxGain12_rf_power\ttxGain13_diag_gain\ttxGain13_pa_gain\ttxGain13_dac_gain\ttxGain13_mix_gain\ttxGain13_rf_power\ttxGain14_diag_gain\ttxGain14_pa_gain\ttxGain14_dac_gain\ttxGain14_mix_gain\ttxGain14_rf_power\ttxGain15_diag_gain\ttxGain15_pa_gain\ttxGain15_dac_gain\ttxGain15_mix_gain\ttxGain15_rf_power\tEUI64\tnws_primary_IpVersion\tnws_primary_Ipv4Address\tnws_primary_Ipv6Address\tnws_primary_Server_port_up\tnws_primary_Server_port_down\tnws_secondary_IpVersion\tnws_secondary_Ipv4Address\tnws_secondary_Ipv6Address\tnws_secondary_Server_port_up\tnws_secondary_Server_port_down\tkeepalive_interval\tstatistics_interval\tkeepalive_count\tpush_timeout_ms\tforward_crc_valid\tforward_crc_error\tforward_crc_disabled\tChannel0_Block\tChannel1_Block\tChannel2_Block\tChannel3_Block\tChannel4_Block\tChannel5_Block\tChannel6_Block\tChannel7_Block\tChannel0_Freq\tChannel1_Freq\tChannel2_Freq\tChannel3_Freq\tChannel4_Freq\tChannel5_Freq\tChannel6_Freq\tChannel7_Freq\tChannel0_Pwr\tChannel1_Pwr\tChannel2_Pwr\tChannel3_Pwr\tChannel4_Pwr\tChannel5_Pwr\tChannel6_Pwr\tChannel7_Pwr\tBackhaulSwitch\tNWSBackhaulSwitch\tBackhaulSwitchCondition\tlbt_threshhold\tjam_threshhold\tvswr_threshhold\tvswr_check\tAlarm_Code1_VSWR_critical\tAlarm_Code1_VSWR_major\tAlarm_Code1_VSWR_minor\tAlarm_Code1_VSWR_normal\tAlarm_Code2_Antenna_critical\tAlarm_Code2_Antenna_major\tAlarm_Code2_Antenna_minor\tAlarm_Code2_Antenna_normal\tAlarm_Code3_Temper_High_critical\tAlarm_Code3_Temper_High_major\tAlarm_Code3_Temper_High_minor\tAlarm_Code3_Temper_High_normal\tAlarm_Code4_Temper_Low_critical\tAlarm_Code4_Temper_Low_major\tAlarm_Code4_Temper_Low_minor\tAlarm_Code4_Temper_Low_normal\tAlarm_Code5_Cpu_critical\tAlarm_Code5_Cpu_major\tAlarm_Code5_Cpu_minor\tAlarm_Code5_Cpu_normal\tAlarm_Code6_Memory_critical\tAlarm_Code6_Memory_major\tAlarm_Code6_Memory_minor\tAlarm_Code6_Memory_normal\tAlarm_Code7_Wan_critical\tAlarm_Code7_Wan_major\tAlarm_Code7_Wan_minor\tAlarm_Code7_Wan_normal\tAlarm_Code8_Wireless_critical\tAlarm_Code8_Wireless_major\tAlarm_Code8_Wireless_minor\tAlarm_Code8_Wireless_normal\tAlarm_Code9_TxLow_critical\tAlarm_Code9_TxLow_major\tAlarm_Code9_TxLow_minor\tAlarm_Code9_TxLow_normal\tAlarm_Code10_Jamming_critical\tAlarm_Code10_Jamming_major\tAlarm_Code10_Jamming_minor\tAlarm_Code10_Jamming_normal\tAlarm_Code11_Gps_critical\tAlarm_Code11_Gps_major\tAlarm_Code11_Gps_minor\tAlarm_Code11_Gps_normal\tAlarm_Code12_NwsConnection_critical\tAlarm_Code12_NwsConnection_major\tAlarm_Code12_NwsConnection_minor\tAlarm_Code12_NwsConnection_normal\tAlarm_Code13_GwConnection_critical\tAlarm_Code13_GwConnection_major\tAlarm_Code13_GwConnection_minor\tAlarm_Code13_GwConnection_normal\tAlarm_Code14_GwAuthentication_critical\tAlarm_Code14_GwAuthentication_major\tAlarm_Code14_GwAuthentication_minor\tAlarm_Code14_GwAuthentication_normal\tAlarm_Code15_DyingGaps_critical\tAlarm_Code15_DyingGaps_major\tAlarm_Code15_DyingGaps_minor\tAlarm_Code15_DyingGaps_normal\tgw_IpVersion\tgw_Ipv4Address\tgw_Ipv6Address\tgw_IpAssignType\tgw_IpPrefix\tgw_GateWayIpv4Address\tgw_GateWayIpv6Address\tgw_NetMaskIpv4Address\t LoRaMacClass0\t LoRaMacClass1\t LoRaMacClass2\tRECEIVE_DELAY1\tRECEIVE_DELAY2\tJOIN_ACCEPT_DELAY1\tJOIN_ACCEPT_DELAY2\tMAX_FCNT_GAP\tADR_ACK_LIMIT\tADR_ACK_DELAY\tACK_TIMEOUT\tBeacon_period\tBeacon_reserved\tBeacon_guard\tBeacon_window\tpingNb\tpingPeriod\tpingOffset\tbeaconTime\tslotLen\tkeepalive_interval\tstatistics_interval\twatchdog_interval\tRemote_SSH_Set_enable\tRemote_SSH_Set_RemotePort\tRemote_HTTP_Set_enable\tRemote_HTTP_Set_RemotePort\tRemote_HTTPS_Set_enable\tRemote_HTTPS_Set_RemotePort\tSchedulelingType";
        String [] strArr = str.split("\t");
        String result = "";
        for (int i = 0; i < strArr.length; i++) {
            if(i == (strArr.length-1)){
                result += strArr[i];
            }else{
                result += strArr[i] + ",";
            }
        }
        System.out.println(result);

    }

}
