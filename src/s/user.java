/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s;

import javafx.scene.control.Button;


public class user {
 String  from, to, p_name, f_date, f_time,  f_number, f_type;

 public user(String  from,String to,String p_name,String f_date,String f_time,String  f_number,String f_type){
    this.f_date= f_date;
    this.f_number=f_number;
    this.f_time=f_time;
    this.f_type=f_type;
    this.from=from;
  //  this.number=number;
    this.p_name=p_name;
    this.to=to;
    
 }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }



    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getF_date() {
        return f_date;
    }

    public void setF_date(String f_date) {
        this.f_date = f_date;
    }

    public String getF_time() {
        return f_time;
    }

    public void setF_time(String f_time) {
        this.f_time = f_time;
    }

    public String getF_number() {
        return f_number;
    }

    public void setF_number(String f_number) {
        this.f_number = f_number;
    }

    public String getF_type() {
        return f_type;
    }

    public void setF_type(String f_type) {
        this.f_type = f_type;
    }

 
}
