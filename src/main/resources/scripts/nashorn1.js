/**
 * Created by gmind on 14. 6. 23.
 */
var fun1 = function(name) {
    print('[JS] : Hi there from Javascript, ' + name);
    return "[JS] greetings from javascript";
};

var fun2 = function (object) {
    print("[JS] Definition: " + Object.prototype.toString.call(object));
};