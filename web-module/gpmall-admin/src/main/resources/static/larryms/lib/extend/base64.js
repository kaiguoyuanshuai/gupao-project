layui.define("jquery",function(r){var e=layui.$;var n="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",t="",a=[256],u=[256],o=0;var c={encode:function(r){var e=r.replace(/[\u0080-\u07ff]/g,function(r){var e=r.charCodeAt(0);return String.fromCharCode(192|e>>6,128|e&63)}).replace(/[\u0800-\uffff]/g,function(r){var e=r.charCodeAt(0);return String.fromCharCode(224|e>>12,128|e>>6&63,128|e&63)});return e},decode:function(r){var e=r.replace(/[\u00e0-\u00ef][\u0080-\u00bf][\u0080-\u00bf]/g,function(r){var e=(r.charCodeAt(0)&15)<<12|(r.charCodeAt(1)&63)<<6|r.charCodeAt(2)&63;return String.fromCharCode(e)}).replace(/[\u00c0-\u00df][\u0080-\u00bf]/g,function(r){var e=(r.charCodeAt(0)&31)<<6|r.charCodeAt(1)&63;return String.fromCharCode(e)});return e}};while(o<256){var f=String.fromCharCode(o);t+=f;u[o]=o;a[o]=n.indexOf(f);++o}function i(r,e,n,t,a,u){r=String(r);var o=0,c=0,f=r.length,i="",d=0;while(c<f){var h=r.charCodeAt(c);h=h<256?n[h]:-1;o=(o<<a)+h;d+=a;while(d>=u){d-=u;var l=o>>d;i+=t.charAt(l);o^=l<<d}++c}if(!e&&d>0)i+=t.charAt(o<<u-d);return i}var d=e.base64=function(r,e,n){return e?d[r](e,n):r?null:this};d.btoa=d.encode=function(r,e){r=d.raw===false||d.utf8encode||e?c.encode(r):r;r=i(r,false,u,n,8,6);return r+"====".slice(r.length%4||4)};d.atob=d.decode=function(r,e){r=r.replace(/[^A-Za-z0-9\+\/\=]/g,"");r=String(r).split("=");var n=r.length;do{--n;r[n]=i(r[n],true,a,t,6,8)}while(n>0);r=r.join("");return d.raw===false||d.utf8decode||e?c.decode(r):r};r("base64",{})});