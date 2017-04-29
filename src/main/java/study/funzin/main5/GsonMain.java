//package study.funzin.main5;
//
//import com.google.gson.*;
//import study.funzin.vo.Company;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by JE on 2017-04-14.
// */
//public class GsonMain {
//
//    public static void main(String [] args){
//
//        Company company = Company.getCompanyDummy();
//
//        System.out.println("========= Object => Json ==========");
//        String company2Json = new Gson().toJson(company);
//        System.out.println(company2Json);
//
//        System.out.println("========= Json => Object =========");
//        Company json2Company = new Gson().fromJson(company2Json, Company.class);
//        printCompanyObject(json2Company);
//
//        System.out.println("========= Object => Json =========");
//        String company2JsonIsNull = new GsonBuilder().serializeNulls().create().toJson(company);
//        System.out.println(company2JsonIsNull);
//
//        System.out.println("========= Json => Object =========");
//        Company json2CompanyIsNull = new Gson().fromJson(company2Json, Company.class);
//        printCompanyObject(json2CompanyIsNull);
//
//    }
//
//    private static void printCompanyObject(Company company) {
//        List<Company.Person> personList = company.getEmployees();
//        System.out.println("userName: " + company.getName());
//        for (Company.Person person : personList) {
//            System.out.println(person);
//        }
//    }
//
//}
