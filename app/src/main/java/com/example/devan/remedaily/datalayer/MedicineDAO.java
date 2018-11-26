/*
    Page Name : Home.java
    Author : Deep Singh (B00792279)
    Purpose : DataStub layer
 */

package com.example.devan.remedaily.datalayer;

import com.example.devan.remedaily.Models.Medicine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MedicineDAO {

    // data stub for medicine DAO
    public ArrayList<Object[]> getUpcomingMedicineDetails(){

        // create dummy dao
        ArrayList<Object[]> arrayDAO = new ArrayList<>();

        // add dummy values
        Object[] dummyStringValue = new Object[5];
        dummyStringValue[0] = 0;
        dummyStringValue[1] = "Medicine001";
        dummyStringValue[2] = "D1";
        dummyStringValue[3] = "U1";
        dummyStringValue[4] =  Calendar.getInstance().getTime().toString();
        arrayDAO.add(dummyStringValue);

        dummyStringValue = new Object[5];
        dummyStringValue[0] = 0;
        dummyStringValue[1] = "Medicine002";
        dummyStringValue[2] = "D2";
        dummyStringValue[3] = "U2";
        dummyStringValue[4] =  Calendar.getInstance().getTime().toString();
        arrayDAO.add(dummyStringValue);

        dummyStringValue = new Object[5];
        dummyStringValue[0] = 0;
        dummyStringValue[1] = "Medicine002";
        dummyStringValue[2] = "D2";
        dummyStringValue[3] = "U2";
        dummyStringValue[4] =  Calendar.getInstance().getTime().toString();
        arrayDAO.add(dummyStringValue);

        dummyStringValue = new Object[5];
        dummyStringValue[0] = 0;
        dummyStringValue[1] = "Medicine002";
        dummyStringValue[2] = "D2";
        dummyStringValue[3] = "U2";
        dummyStringValue[4] =  Calendar.getInstance().getTime().toString();
        arrayDAO.add(dummyStringValue);

        dummyStringValue = new Object[5];
        dummyStringValue[0] = 0;
        dummyStringValue[1] = "Medicine002";
        dummyStringValue[2] = "D2";
        dummyStringValue[3] = "U2";
        dummyStringValue[4] =  Calendar.getInstance().getTime().toString();
        arrayDAO.add(dummyStringValue);

        return arrayDAO;
    }

    // data stub for missed medicine DAO
    public ArrayList<Object[]> getMissedMedicineDetails(){

        // create dummy dao
        ArrayList<Object[]> arrayDAO = new ArrayList<>();

        // add dummy values
        Object[] dummyStringValue = new Object[5];
        dummyStringValue[0] = 0;
        dummyStringValue[1] = "Medicine003";
        dummyStringValue[2] = "D1";
        dummyStringValue[3] = "U1";
        dummyStringValue[4] =  Calendar.getInstance().getTime().toString();
        arrayDAO.add(dummyStringValue);

        return arrayDAO;
    }

    public ArrayList<String> getMedicineDates() {
        ArrayList<String> DateList = new ArrayList<>();

        DateList.add("1/11/2018");
        DateList.add("2/11/2018");
        DateList.add("3/11/2018");
        DateList.add("4/11/2018");

        return DateList;
    }

    public ArrayList<Medicine> getMedicineDataStubByDateTime(String Date){
        ArrayList<Medicine> MedicineList = new ArrayList<>();
        String dtDate = Date.toString().split("/")[2];
        String dtMonth = Date.toString().split("/")[1];
        String dtDay = Date.toString().split("/")[0];
        
        if(dtDate.equals("2018") && dtMonth.equals("11") && dtDay.equals("1")){
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_1_001","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_1_002","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_1_003","TestMedicineDosage_2018_11_1_001","0001"));
        }

        if(dtDate.equals("2018") && dtMonth.equals("11")  && dtDay.equals("2")){
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_2_001","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_2_002","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_2_003","TestMedicineDosage_2018_11_1_001","0001"));
        }

        if(dtDate.equals("2018") && dtMonth.equals("11")  && dtDay.equals("3")){
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_3_001","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_3_002","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_3_003","TestMedicineDosage_2018_11_1_001","0001"));
        }

        if(dtDate.equals("2018") && dtMonth.equals("11")  && dtDay.equals("4")){
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_4_001","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_4_002","TestMedicineDosage_2018_11_1_001","0001"));
            MedicineList.add(new Medicine(0,"TestMedcine_2018_11_4_003","TestMedicineDosage_2018_11_1_001","0001"));
        }

        return  MedicineList;
    }

    public ArrayList<Medicine> getDailyMedicineListDataStub() {
        ArrayList<Medicine> MedicineList = new ArrayList<>();
        MedicineList.add(new Medicine(0,"TestDailyMedcine_2018_11_1_001","TestMedicineDosage_2018_11_1_001","0001"));
        MedicineList.add(new Medicine(0,"TestDailyMedcine_2018_11_1_002","TestMedicineDosage_2018_11_1_001","0001"));
        MedicineList.add(new Medicine(0,"TestDailyMedcine_2018_11_1_003","TestMedicineDosage_2018_11_1_001","0001"));

        return MedicineList;
    }
}
