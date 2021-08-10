package houserent.view;

import houserent.domain.House;
import houserent.service.HouseService;
import houserent.utils.Utility;

/**
 * 1. 显示界面
 * 2. 接收用户的输入
 * 3. 调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private HouseService houseService = new HouseService(2);
    boolean loop = true;
    char key = ' '; //接收用户输入选择


    //修改房源信息
    public void modifyHouse() {
        System.out.println("----------修改房屋----------");
        System.out.print("请选择待修改房屋的编号(-1退出)：");

        int modifyId = Utility.readInt();
        if (modifyId == -1) {
            System.out.println("----------放弃修改房屋信息----------");
            return;
        }

        House house = houseService.searchById(modifyId);
        if (house == null) {
            System.out.println("----------房屋编号不存在，修改失败----------");
            return;
        }

        System.out.print("姓名(" + house.getName() + "):");
        String name = Utility.readString(8, "");
        if (!name.equals("")) {
            house.setName(name);
        }

        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!phone.equals("")) {
            house.setPhone(phone);
        }


        System.out.print("地区(" + house.getAddress() + "):");
        String address = Utility.readString(12, "");
        if (!address.equals("")) {
            house.setAddress(address);
        }


        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (!(rent == -1)) {
            house.setRent(rent);
        }

        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!state.equals("")) {
            house.setState(state);
        }
    }

    // 根据id查找房屋信息的功能
    public void searchHouse() {
        System.out.println("----------查找房屋----------");
        System.out.print("请输入你要查找的房屋的编号：");
        int searchId = Utility.readInt();
        House house = houseService.searchById(searchId);
        if (house == null) {
            System.out.println("----------编号不存在，查找失败----------");
        }
        System.out.println(house);
    }

    //完成确认退出
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    //删除房屋信息
    public void delHouse() {
        System.out.println("----------删除房屋信息----------");
        System.out.print("请输入要删除的房屋的编号(-1退出)：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("----------放弃删除房屋信息----------");
            return;
        }

        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("----------删除房屋信息成功----------");
            } else {
                System.out.println("----------房屋编号不存在，删除失败----------");
            }
        } else {
            System.out.println("----------放弃删除房屋信息----------");
        }

    }

    //编写addHouse()
    public void addHouse() {
        System.out.println("----------添加房屋----------");
        System.out.print("姓名:");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        //创建一个House对象，注意id是系统分配的
        House newHouse = new House(0, name, phone, address, rent, state);

        if (houseService.add(newHouse)) {
            System.out.println("----------添加房屋成功----------");
        } else {
            System.out.println("----------添加房屋失败----------");
        }
    }

    //显示房屋列表
    public void listHouse() {
        System.out.println("----------房屋列表----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("----------房屋列表显示完毕----------");

    }

    public void mainMenu() {
        do {
            System.out.println("------------房屋出租系统------------");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退       出");
            System.out.print("请输入(1-6):");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    searchHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    modifyHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }

        } while (loop);

    }
}
