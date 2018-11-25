package com.json_java;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(Include.NON_NULL)//For ignore null in JSON body
public class POJORead2
{
    public POJORead2(String fruit, String color, String size,Integer prize) {
		this.fruit = fruit;
		this.color = color;
		this.size = size;
		this.prize=prize;
	}

	private String fruit;

    private String color;

    private String size;
    
    private Integer prize;

    public Integer getPrize() {
		return prize;
	}

	public void setPrize(Integer prize) {
		this.prize = prize;
	}

	public String getFruit ()
    {
        return fruit;
    }

    public void setFruit (String fruit)
    {
        this.fruit = fruit;
    }

    public String getColor ()
    {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }



    
}