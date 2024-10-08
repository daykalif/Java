package com.itheima.interfacedemo10;

/*
 *	适配器设计模式：
 * 		- 设计模式（Design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。
 * 		  使用设计模式是为了可重用代码、让代码更容易被人理解、保证代码可靠性、程序的重用性。
 * 	简单理解：设计模式就是各种套路。
 * 	适配器设计模式：解决接口与接口实现类之间的矛盾问题
 *
 * 	总结：
 * 		1.当一个接口中抽象方法过多，但是我只要使用其中一部分的时候，就可以用适配器设计模式
 * 		2.书写步骤：
 * 			编写中间类XXXXAdapter，实现对应的接口，
 * 			对接口中的抽象方法进行空实现，
 * 			让真正的实现类继承中间类，并重写需要用的方法，
 * 			为了避免其他类创建适配器类的对象，中间的适配器类，用abstract进行修饰
 * 		3.如果实现类本身需要继承第三方类，此时变更成继承这个中间类以后，无法继承第三方类怎么办？
 * 			可以让这个中间类继承第三方类，再由实现类继承这个中间类，实现多层继承
 */
public class Test {
}
