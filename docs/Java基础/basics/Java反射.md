 #### Java反射机制
 Java反射机制是指在运行状态中，对于任意一个实体类，都能够知道这个类的所有属性和方法；  
 对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法  
 的功能称为Java语言的反射机制。（运行状态中知道类所有的属性和方法）
 #### 动态语言
 动态语言，是指程序在运行时可以改变其结构：新的函数可以引进，已有的函数可以被删除等结构上  
 的变化。比如常见的 JavaScript 就是动态语言，除此之外 Ruby, Python 等也属于动态语言，  
 而 C、C++则不属于动态语言。从反射角度说 Java 属于半动态语言。
 #### 反射机制的应用场景
 * 逆向代码，例如反编译
 * 与注解相结合的框架，例如Retrofit
 * 单纯的反射机制应用框架，例如EventBus 2.x
 * 动态生成类框架，例如Gson
 #### Java反射API
 * Class类：反射的核心类，可以获取类的属性、方法等信息。
 * Field类：java.lang.reflect包中的类，表示类的成员变量，可以用来获取和设置类中的属性值。
 * Method类：java.lang.reflect包中的类，表示类的方法，它可以用来获取类中的方法信息或执行方法。
 * Constructor类：java.lang.reflect包中的类，表示类的构造方法。
 #### 获取Class对象的三种方法
 * 调用某个对象的`getClass()`方法
 ~~~
 Person p = new Person();
 Class clazz = p.getClass();
 ~~~
 * 调用某个类的`class`属性来获取该类对应的Class对象  
 `Class clazz = Person.class`
 * 使用Class类中的`forName()`静态方法（最安全/性能最好/最常用）
 `Class clazz = Class.forName("com.xxx.function.className")`
 #### 使用反射获取的对象创建对象的两种方法
 * Class对象的`newInstance()`  
 这种方法要求对应的类有默认的空构造器
 ~~~
 Class clazz = Class.forName("com.xxx.model.Person");
 Person p = (Person) clazz.newINstance();
 ~~~
 * 调用Constructor类的`newInstance()`
 通过这种方法可以选定构造方法创建实例
 ~~~
 Class clazz = Class.forName("com.xxx.model.Person");
 Constructor c = clazz.getDeclaredConstructor(String.class, String.class, int.class);
 Person p = (Person) c.newInstance("张三", "男", 20);
 ~~~