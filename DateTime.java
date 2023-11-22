package pract5;

import pract4.TimeInstant;
/**
 * La clase {@code DateTime} permite representar un instante de una fecha 
 * (dia, mes y anyo) concreta.
 * 
 * @author IIP 
 * @version Curso 2023-24
 */
public class DateTime { 
    // Atributos
    /** Atributo privado que representa el día del DateTime. */
    private int day;  
    /** Atributo privado que representa el mes del DateTime.*/
    private int month;
    /** Atributo privado que representa el anyo del DateTime. */
    private int year;
    /** Atributo privado que representa el instante del DateTime. */
    private TimeInstant instant;
   
    /**
     * Crea un DateTime con los valores dados de día, mes, anyo, 
     * horas y minutos, suponiendo que son correctos. 
     * @param d int día del DateTime.
     * @param m int mes del DateTime.
     * @param y int anyo del DateTime.
     * @param hour int horas del DateTime.
     * @param min int minutos del DateTime.
     */
    public DateTime(int d, int m, int y, int hour, int min) {
        day = d;
        month = m;
        year = y;
        instant = new TimeInstant(hour, min);
    }
    
    /** 
     * Crea un DateTime con los valores dados de día, mes y anyo  
     * (suponiendo que son correctos) y el instante UTC actual. 
     * @param d int día del DateTime.
     * @param m int mes del DateTime.
     * @param y int anyo del DateTime.
     */
    public DateTime(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
        instant = new TimeInstant();
    }
    
    /**
     * Devuelve el día del DateTime en curso.
     * @return {@code int}, el día.
     */
    public int getDay() { return day; }
   
    /**
     * Devuelve el mes del DateTime en curso.
     * @return {@code int}, el mes.
     */
    public int getMonth() { return month; }
   
    /**
     * Devuelve el anyo del DateTime en curso.
     * @return {@code int}, el anyo.
     */
    public int getYear() { return year; }
    
    /**
     * Devuelve el instante del DateTime en curso.
     * @return {@link TimeInstant}, el instante.
     */
    public TimeInstant getInstant() { return instant; }
   
    /**
     * Actualiza el dia del DateTime en curso.
     * @param d int el nuevo día.
     */
    public void setDay(int d) { day = d; }
   
    /**
     * Actualiza el mes del DateTime en curso.
     * @param m int el nuevo mes.
     */
    public void setMonth(int m) { month = m; }
   
    /**
     * Actualiza el anyo del DateTime en curso.
     * @param y int el nuevo anyo.
     */
    public void setYear(int y) { year = y; }
   
    /**
     * Actualiza el instante del DateTime en curso.
     * @param h int las nuevas horas.
     * @param m int los nuevos minutos.
     */
    public void setInstant(int h, int m) { 
        instant.setHours(h);
        instant.setMinutes(m);
    }
         
    /** 
     *  Devuelve un String como representació del DateTime en curs
     *  en el formato "hh:mm dd/mm/yyyy".
     *  @return {@link String}, DateTime en el formato "hh:mm dd/mm/yyyy".
     */
    public String toString() {
        // Versión 1:
        // String dd = "0" + day;
        // dd = dd.substring(dd.length() - 2);
        // String mm = "0" + month;
        // mm = mm.substring(mm.length() - 2);
        // String yyyy = "000" + year;
        // yyyy = yyyy.substring(yyyy.length() - 4);
        
        // Versión 2:
        // String dd = day / 10 + "" + day % 10;
        // String mm = month / 10 + "" + month % 10;
        // String yyyy = year / 1000 + "" 
                    // + (year % 1000) / 100 + ""
                    // + ((year % 1000) % 100) / 10 + ""
                    // + ((year % 1000) % 100) % 10;
                    
        // Versión 3:   
        String dd = "" + day;
        // COMPLETAR dd con un cero si es necesario
        if (day < 10) { 
            dd = "0" + dd;
        }
        
        String mm = "" + month;
        // COMPLETAR mm con un cero si es necesario
        if (month < 10) {
            mm = "0" + mm;
        }
        
        String yyyy = "" + year;
        // COMPLETAR yyyy con ceros si es necesario
        if (year < 10) {
            yyyy = "000" + yyyy;
        }
        else if (year < 100) {
            yyyy = "00" + yyyy;
        }
        else if (year < 1000) {
            yyyy = "0" + yyyy;
        }
        
        return instant + " " + dd + "/" + mm + "/" + yyyy;        
    } 
   
    /**
     * Comprueba si el DateTime en curso es igual a otro dado.
     * @param o Object.
     * @return {@code boolean}, {@code true} si instante, día, mes y anyo
     * del DateTime en curso coinciden con los del DateTime dado y 
     * {@code false} en caso contrario.
     */
    public boolean equals(Object o) {
        // COMPLETAR, cambiando el return por lo que corresponda
        if (o instanceof DateTime) {
            return this.day == ((DateTime) o).day
                && this.month == ((DateTime) o).month
                && this.year == ((DateTime) o).year
                && this.instant.equals(((DateTime) o).instant);
        }
        else { 
            return false;
        }
    } 
  
    /** 
     * Compara cronológicamente el DateTime en curso con un DateTime dado.
     * @param d referencia a un objeto de la clase {@link DateTime} 
     * a comparar con el DateTime en curso.
     * @return {@code int}, devuelve un valor negativo, positivo o cero si el DateTime 
     * en curso es, respectivamente, anterior, posterior o igual al DateTime dado.
     */
    public int compareTo(DateTime d) {
        // Versión 1:
        //int res = 1;
        //if (year < d.year) { res = -1; }
        //else if (year == d.year) {
            //if (month < d.month) { res = -1; }
            //else if (month == d.month) {
                //if (day < d.day) { res = -1; }
                //else if (day == d.day) {
                    //res = instant.compareTo(d.instant);
                //}
            //}
        //}
        //return res;
        
        // Versión 2:
        // COMENTAR la Versión 1 y COMPLETAR la Versión 2 siguiendo 
        // lo que se indica en el boletín de la práctica 5
        int res = this.year - d.year;
        if (res == 0) {
            res = this.month - d.month;
            if (res == 0) {
                res = this.day - d.day;
                if (res == 0) {
                    res = this.instant.compareTo(d.instant);
                }
            }
        }
        return res;
    }    
    
    /**
     * Comprueba si un anyo dado es bisiesto.
     * @param year int el anyo.
     * @return {@code boolean}, devuelve {@code true} si el anyo es bisiesto 
     *  y {@code false} en caso contrario.
     */   
    public static boolean isLeap(int year) { 
        // Anyo bisiesto es el divisible entre 4, a menos que sea 
        // anyo secular -último de cada siglo, acabado en "00"-,  
        // en cuyo caso también ha de ser divisible entre 400.
        // Wikipedia, consulta 06/07/2022
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0); 
    }    
   
    /** 
     * Devuelve la duración de un mes de un anyo dado en días.
     * @param month int el mes.
     * @param year int el anyo.
     * @return {@code int}, los días del mes del anyo.
     */
    public static int lengthOfMonth(int month, int year) {
        int numberOfDays = 31;
        if (month == 2) { 
            numberOfDays = 28;
            if (isLeap(year)) { numberOfDays = 29; }
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11) { numberOfDays = 30; }
        return numberOfDays;
    }
    
    /** 
     * Comprueba si los datos de horas, minutos, día, mes y anyo dados 
     * corresponden a un instante y una fecha correctos.
     * @param hours int las horas.
     * @param min int los minutos.
     * @param day int el día.
     * @param month int el mes.
     * @param year int el anyo.
     * @return {@code boolean}, devuelve {@code true} si los datos son correctos 
     * y {@code false} en caso contrario.
     */
    public static boolean isCorrect(int hours, int min, int day, int month, int year) {
        boolean correct = false;
        if (0 <= hours && hours <= 23 && 0 <= min && min <= 59) {
            if (year > 0 && (month >= 1 && month <= 12) && (day >= 1 && day <= 31)) {
                int numberOfDays = lengthOfMonth(month, year);
                if (day <= numberOfDays) { correct = true; }
            }
        }
        return correct;
    }
}
