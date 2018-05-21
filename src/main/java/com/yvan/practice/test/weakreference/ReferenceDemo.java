package com.yvan.practice.test.weakreference;

import com.yvan.practice.entity.mysql.user.User;

import java.lang.ref.WeakReference;

public class ReferenceDemo {

    public void weakReferenceObject(){
        User user = new User();
        user.setUsername("Jack");
        WeakReference<String> weakReference = new WeakReference(user);
        int i = 0;
        System.out.println(weakReference.isEnqueued());
        while (true){
            System.out.println(weakReference.isEnqueued());
            if (weakReference.get() != null) {
                i++;
                System.out.println("Object is alive for "+i+" loops - "+weakReference);
            }else {
                System.out.println("it's so magic,Object has been collected.");
                break;
            }
        }
    }

    public void weakReferenceObject2() {
        User user = new User();
        user.setUsername("Jack");
        WeakReference<User> weakReference = new WeakReference(user);
        int i = 0;
        while (true) {
            /** 添加了此强引用 weakReference将不会被回收 */
            System.out.println("here is the strong reference 'weakReference' " + weakReference.get().getUsername());
            if (weakReference.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + weakReference);
            } else {
                System.out.println("it's so magic,Object has been collected.");
                break;
            }
        }
    }



}
