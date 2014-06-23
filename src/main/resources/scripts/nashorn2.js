/**
 * Created by gmind on 14. 6. 23.
 */
var Nashorn2 = Java.type('io.gmind.java8.nashorn.Nashorn2');
var result = Nashorn2.fun('John Doe');
print('[JS] :' + result);

Nashorn2.fun2(123);
Nashorn2.fun2(49.99);
Nashorn2.fun2(true);
Nashorn2.fun2("hi there")
Nashorn2.fun2(String("bam"))
Nashorn2.fun2(new Number(23));
Nashorn2.fun2(new Date());
Nashorn2.fun2(new RegExp());
Nashorn2.fun2({foo: 'bar'});


print('[JS] passing object hash:');
Nashorn2.fun3({
    foo: 'bar',
    bar: 'foo'
});


print('[JS] passing custom person object:');

function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.getFullName = function() {
        return this.firstName + " " + this.lastName;
    }
}

var person1 = new Person("Peter", "Parker");
Nashorn2.fun3(person1);
Nashorn2.fun4(person1);