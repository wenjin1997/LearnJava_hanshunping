package com.jinjin;

import org.junit.jupiter.api.Test;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
    }

    @Test
    public void testDAO(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001",new User(1, 20, "jack"));
        userDAO.save("002",new User(2, 10, "mary"));
        userDAO.save("003",new User(3, 23, "smith"));
        System.out.println("list=" + userDAO.list());

        System.out.println("----update----");
        userDAO.update("001", new User(1, 13, "Tom"));
        System.out.println("list=" + userDAO.list());

        System.out.println("----delete----");
        userDAO.delete("002");
        System.out.println("list=" + userDAO.list());
    }
}
