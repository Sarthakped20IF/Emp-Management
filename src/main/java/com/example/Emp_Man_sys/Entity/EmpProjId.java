package com.example.Emp_Man_sys.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@EqualsAndHashCode
public class EmpProjId implements Serializable {
    private Long emp_id;
    private Long proj_id;


    @Override
    public boolean equals(Object o){
        if (this == o)return true;
        if (! (o instanceof EmpProjId))return false;

        EmpProjId that = (EmpProjId) o;
        return Objects.equals(emp_id,that.emp_id)&&
                Objects.equals(proj_id,that.proj_id);
    }
    public int hashCode(){
        return Objects.hash(emp_id,proj_id);
    }
}
