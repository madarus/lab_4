import controller.ErrMsgLog;
import models.AlcoCoctail;
import models.Coctail;
import models.Cooking;
import models.Ingredient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static ArrayList<Coctail> lists;
    public static LinkedList<Coctail> lists2;

    public static void main(String[] args) throws IOException {

        ErrMsgLog myerr = new ErrMsgLog();
        try {
            Ingredient ing1 = new Ingredient("Виски",-1,40, Cooking.POUR.toString());
            if((ing1.amount <=0)){
                throw myerr.makeErr(new Exception("Неверный объем ингредиента"));
            }
        }
        catch (Exception e) {
            myerr.addErrWithLog(e); //Добавляем ошибку в список и пишем в лог без отображения в консоли
            myerr.showErrText(e); //Отображаем ошибку
        }

        addModels(10);
    }


    static void addModels(int n){
        AddDataToArray data = new AddDataToArray();
        lists = data.coctailsData(n);
        for(Coctail st:lists){
            System.out.println();
            System.out.println("Название: "+ st.name);
            System.out.println("Ингредиенты: "+st.Ingredients);
            System.out.println("Действия: "+st.cooking);
            System.out.println("Объем: "+st.amount);
        }
        data.remove(n);
        data.toFile();
        System.out.println("\nLinkedList");
        AddDataToLinked data2 = new AddDataToLinked();
        lists2 = data2.coctailsData(n);
        for (Coctail st:lists2){
            System.out.println();
            System.out.println("Название: "+ st.name);
            System.out.println("Ингредиенты: "+st.Ingredients);
            System.out.println("Действия: "+st.cooking);
            System.out.println("Объем: "+st.amount);
        }
        data2.remove(n);
    }
}