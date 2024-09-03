package com.example.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    int lastId;
    List<Person> people;
    HomeController(){
        lastId=0;
        people=new ArrayList<>();
    }

    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson(@RequestParam("name")String name, @RequestParam("age")int age){
        lastId++;
        Person p=new Person(lastId,name,age);
        people.add(p);


        return String.format("%d 번째 사람이 추가 되었습니다.",p.getId());
    }

    @GetMapping("/person/people")
    @ResponseBody
    public List<Person> getPeople(){
        System.out.println(people);
        return people;
    }
}

@Getter
@Setter
@AllArgsConstructor
class Person{
    private  int id;
    private  String name;
    private  int age;
}