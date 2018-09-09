package com.andreitop.newco.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutContainer {

    @Pointcut("execution(* com.andreitop.newco.repository.*Repo*.find*())")
    public void repositoryFind() {
        //
    }

    @Pointcut("within(com.andreitop.newco.service.*)")
    public void serviceMethods(){
        //
    }

    @Pointcut("this(com.andreitop.newco.controller.NewcoController))")
    public void controllerMethods(){
        //
    }

    @Pointcut("execution(* com.andreitop.newco.repository.TripRepository.save*(..))")
    public void repositorySave(){
        //
    }

    @Pointcut("execution(* com.andreitop.newco.repository.TripRepository.throwingExc())")
    public void throwingExc() {
        //
    }
}
