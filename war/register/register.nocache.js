<<<<<<< HEAD
function register(){var N='',ub='" for "gwt:onLoadErrorFn"',sb='" for "gwt:onPropertyErrorFn"',gb='"><\/script>',X='#',Pb='.cache.html',Z='/',Ob=':',mb='::',Xb='<script defer="defer">register.onInjectionDone(\'register\')<\/script>',fb='<script id="',pb='=',Y='?',rb='Bad handler "',Wb='DOMContentLoaded',Nb="GWT module 'register' may need to be (re)compiled",hb='SCRIPT',eb='__gwt_marker_register',ib='base',ab='baseUrl',R='begin',Q='bootstrap',_='clear.cache.gif',ob='content',W='end',Hb='gecko',Ib='gecko1_8',S='gwt.codesvr=',T='gwt.hosted=',U='gwt.hybrid',Qb='gwt/chrome/chrome.css',tb='gwt:onLoadErrorFn',qb='gwt:onPropertyErrorFn',nb='gwt:property',Vb='head',Lb='hosted.html?register',Ub='href',Gb='ie6',Fb='ie8',Eb='ie9',vb='iframe',$='img',wb="javascript:''",Rb='link',Kb='loadExternalRefs',jb='meta',yb='moduleRequested',V='moduleStartup',Db='msie',kb='name',Ab='opera',xb='position:absolute;width:0;height:0;border:none',O='register',cb='register.nocache.js',lb='register::',Sb='rel',Cb='safari',bb='script',Mb='selectingPermutation',P='startup',Tb='stylesheet',db='undefined',Jb='unknown',zb='user.agent',Bb='webkit';var l=window,m=document,n=l.__gwtStatsEvent?function(a){return l.__gwtStatsEvent(a)}:null,o=l.__gwtStatsSessionId?l.__gwtStatsSessionId:null,p,q,r,s=N,t={},u=[],v=[],w=[],x=0,y,z;n&&n({moduleName:O,sessionId:o,subSystem:P,evtGroup:Q,millis:(new Date).getTime(),type:R});if(!l.__gwt_stylesLoaded){l.__gwt_stylesLoaded={}}if(!l.__gwt_scriptsLoaded){l.__gwt_scriptsLoaded={}}function A(){var b=false;try{var c=l.location.search;return (c.indexOf(S)!=-1||(c.indexOf(T)!=-1||l.external&&l.external.gwtOnLoad))&&c.indexOf(U)==-1}catch(a){}A=function(){return b};return b}
function B(){if(p&&q){var b=m.getElementById(O);var c=b.contentWindow;if(A()){c.__gwt_getProperty=function(a){return F(a)}}register=null;c.gwtOnLoad(y,O,s,x);n&&n({moduleName:O,sessionId:o,subSystem:P,evtGroup:V,millis:(new Date).getTime(),type:W})}}
function C(){function e(a){var b=a.lastIndexOf(X);if(b==-1){b=a.length}var c=a.indexOf(Y);if(c==-1){c=a.length}var d=a.lastIndexOf(Z,Math.min(c,b));return d>=0?a.substring(0,d+1):N}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=m.createElement($);b.src=a+_;a=e(b.src)}return a}
function g(){var a=E(ab);if(a!=null){return a}return N}
function h(){var a=m.getElementsByTagName(bb);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(cb)!=-1){return e(a[b].src)}}return N}
function i(){var a;if(typeof isBodyLoaded==db||!isBodyLoaded()){var b=eb;var c;m.write(fb+b+gb);c=m.getElementById(b);a=c&&c.previousSibling;while(a&&a.tagName!=hb){a=a.previousSibling}if(c){c.parentNode.removeChild(c)}if(a&&a.src){return e(a.src)}}return N}
function j(){var a=m.getElementsByTagName(ib);if(a.length>0){return a[a.length-1].href}return N}
var k=g();if(k==N){k=h()}if(k==N){k=i()}if(k==N){k=j()}if(k==N){k=e(m.location.href)}k=f(k);s=k;return k}
function D(){var b=document.getElementsByTagName(jb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(kb),g;if(f){f=f.replace(lb,N);if(f.indexOf(mb)>=0){continue}if(f==nb){g=e.getAttribute(ob);if(g){var h,i=g.indexOf(pb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=N}t[f]=h}}else if(f==qb){g=e.getAttribute(ob);if(g){try{z=eval(g)}catch(a){alert(rb+g+sb)}}}else if(f==tb){g=e.getAttribute(ob);if(g){try{y=eval(g)}catch(a){alert(rb+g+ub)}}}}}}
function E(a){var b=t[a];return b==null?null:b}
function F(a){var b=v[a](),c=u[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(z){z(a,d,b)}throw null}
var G;function H(){if(!G){G=true;var a=m.createElement(vb);a.src=wb;a.id=O;a.style.cssText=xb;a.tabIndex=-1;m.body.appendChild(a);n&&n({moduleName:O,sessionId:o,subSystem:P,evtGroup:V,millis:(new Date).getTime(),type:yb});a.contentWindow.location.replace(s+J)}}
v[zb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return b.indexOf(Ab)!=-1}())return Ab;if(function(){return b.indexOf(Bb)!=-1}())return Cb;if(function(){return b.indexOf(Db)!=-1&&m.documentMode>=9}())return Eb;if(function(){return b.indexOf(Db)!=-1&&m.documentMode>=8}())return Fb;if(function(){var a=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(a&&a.length==3)return c(a)>=6000}())return Gb;if(function(){return b.indexOf(Hb)!=-1}())return Ib;return Jb};u[zb]={gecko1_8:0,ie6:1,ie8:2,ie9:3,opera:4,safari:5};register.onScriptLoad=function(){if(G){q=true;B()}};register.onInjectionDone=function(){p=true;n&&n({moduleName:O,sessionId:o,subSystem:P,evtGroup:Kb,millis:(new Date).getTime(),type:W});B()};D();C();var I;var J;if(A()){if(l.external&&(l.external.initModule&&l.external.initModule(O))){l.location.reload();return}J=Lb;I=N}n&&n({moduleName:O,sessionId:o,subSystem:P,evtGroup:Q,millis:(new Date).getTime(),type:Mb});if(!A()){try{alert(Nb);return;var K=I.indexOf(Ob);if(K!=-1){x=Number(I.substring(K+1));I=I.substring(0,K)}J=I+Pb}catch(a){return}}var L;function M(){if(!r){r=true;if(!__gwt_stylesLoaded[Qb]){var a=m.createElement(Rb);__gwt_stylesLoaded[Qb]=a;a.setAttribute(Sb,Tb);a.setAttribute(Ub,s+Qb);m.getElementsByTagName(Vb)[0].appendChild(a)}B();if(m.removeEventListener){m.removeEventListener(Wb,M,false)}if(L){clearInterval(L)}}}
if(m.addEventListener){m.addEventListener(Wb,function(){H();M()},false)}var L=setInterval(function(){if(/loaded|complete/.test(m.readyState)){H();M()}},50);n&&n({moduleName:O,sessionId:o,subSystem:P,evtGroup:Q,millis:(new Date).getTime(),type:W});n&&n({moduleName:O,sessionId:o,subSystem:P,evtGroup:Kb,millis:(new Date).getTime(),type:R});m.write(Xb)}
=======
function register(){var O='',vb='" for "gwt:onLoadErrorFn"',tb='" for "gwt:onPropertyErrorFn"',hb='"><\/script>',Y='#',Vb='.cache.html',$='/',Ob='2FF887B84770E20B4B269181056D8038',Pb='6CEA33A16746A7FE4654AB168CDDB883',Qb='9479C3AD7C93E3E04276D0500CAC3A45',Ub=':',nb='::',bc='<script defer="defer">register.onInjectionDone(\'register\')<\/script>',gb='<script id="',qb='=',Z='?',sb='Bad handler "',Rb='D9B473AD9ABBEFA4C69ABEC6D2C062AE',ac='DOMContentLoaded',Sb='E28140E9FCE904C2CA053A0BA7CA0437',Tb='F9D914F2F51C513C1B97D637AE19D561',ib='SCRIPT',fb='__gwt_marker_register',jb='base',bb='baseUrl',S='begin',R='bootstrap',ab='clear.cache.gif',pb='content',X='end',Ib='gecko',Jb='gecko1_8',T='gwt.codesvr=',U='gwt.hosted=',V='gwt.hybrid',Wb='gwt/chrome/chrome.css',ub='gwt:onLoadErrorFn',rb='gwt:onPropertyErrorFn',ob='gwt:property',_b='head',Mb='hosted.html?register',$b='href',Hb='ie6',Gb='ie8',Fb='ie9',wb='iframe',_='img',xb="javascript:''",Xb='link',Lb='loadExternalRefs',kb='meta',zb='moduleRequested',W='moduleStartup',Eb='msie',lb='name',Bb='opera',yb='position:absolute;width:0;height:0;border:none',P='register',db='register.nocache.js',mb='register::',Yb='rel',Db='safari',cb='script',Nb='selectingPermutation',Q='startup',Zb='stylesheet',eb='undefined',Kb='unknown',Ab='user.agent',Cb='webkit';var l=window,m=document,n=l.__gwtStatsEvent?function(a){return l.__gwtStatsEvent(a)}:null,o=l.__gwtStatsSessionId?l.__gwtStatsSessionId:null,p,q,r,s=O,t={},u=[],v=[],w=[],x=0,y,z;n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:S});if(!l.__gwt_stylesLoaded){l.__gwt_stylesLoaded={}}if(!l.__gwt_scriptsLoaded){l.__gwt_scriptsLoaded={}}function A(){var b=false;try{var c=l.location.search;return (c.indexOf(T)!=-1||(c.indexOf(U)!=-1||l.external&&l.external.gwtOnLoad))&&c.indexOf(V)==-1}catch(a){}A=function(){return b};return b}
function B(){if(p&&q){var b=m.getElementById(P);var c=b.contentWindow;if(A()){c.__gwt_getProperty=function(a){return G(a)}}register=null;c.gwtOnLoad(y,P,s,x);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:X})}}
function C(){function e(a){var b=a.lastIndexOf(Y);if(b==-1){b=a.length}var c=a.indexOf(Z);if(c==-1){c=a.length}var d=a.lastIndexOf($,Math.min(c,b));return d>=0?a.substring(0,d+1):O}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=m.createElement(_);b.src=a+ab;a=e(b.src)}return a}
function g(){var a=E(bb);if(a!=null){return a}return O}
function h(){var a=m.getElementsByTagName(cb);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(db)!=-1){return e(a[b].src)}}return O}
function i(){var a;if(typeof isBodyLoaded==eb||!isBodyLoaded()){var b=fb;var c;m.write(gb+b+hb);c=m.getElementById(b);a=c&&c.previousSibling;while(a&&a.tagName!=ib){a=a.previousSibling}if(c){c.parentNode.removeChild(c)}if(a&&a.src){return e(a.src)}}return O}
function j(){var a=m.getElementsByTagName(jb);if(a.length>0){return a[a.length-1].href}return O}
var k=g();if(k==O){k=h()}if(k==O){k=i()}if(k==O){k=j()}if(k==O){k=e(m.location.href)}k=f(k);s=k;return k}
function D(){var b=document.getElementsByTagName(kb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(lb),g;if(f){f=f.replace(mb,O);if(f.indexOf(nb)>=0){continue}if(f==ob){g=e.getAttribute(pb);if(g){var h,i=g.indexOf(qb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=O}t[f]=h}}else if(f==rb){g=e.getAttribute(pb);if(g){try{z=eval(g)}catch(a){alert(sb+g+tb)}}}else if(f==ub){g=e.getAttribute(pb);if(g){try{y=eval(g)}catch(a){alert(sb+g+vb)}}}}}}
function E(a){var b=t[a];return b==null?null:b}
function F(a,b){var c=w;for(var d=0,e=a.length-1;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
function G(a){var b=v[a](),c=u[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(z){z(a,d,b)}throw null}
var H;function I(){if(!H){H=true;var a=m.createElement(wb);a.src=xb;a.id=P;a.style.cssText=yb;a.tabIndex=-1;m.body.appendChild(a);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:W,millis:(new Date).getTime(),type:zb});a.contentWindow.location.replace(s+K)}}
v[Ab]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return b.indexOf(Bb)!=-1}())return Bb;if(function(){return b.indexOf(Cb)!=-1}())return Db;if(function(){return b.indexOf(Eb)!=-1&&m.documentMode>=9}())return Fb;if(function(){return b.indexOf(Eb)!=-1&&m.documentMode>=8}())return Gb;if(function(){var a=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(a&&a.length==3)return c(a)>=6000}())return Hb;if(function(){return b.indexOf(Ib)!=-1}())return Jb;return Kb};u[Ab]={gecko1_8:0,ie6:1,ie8:2,ie9:3,opera:4,safari:5};register.onScriptLoad=function(){if(H){q=true;B()}};register.onInjectionDone=function(){p=true;n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:Lb,millis:(new Date).getTime(),type:X});B()};D();C();var J;var K;if(A()){if(l.external&&(l.external.initModule&&l.external.initModule(P))){l.location.reload();return}K=Mb;J=O}n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:Nb});if(!A()){try{F([Jb],Ob);F([Bb],Pb);F([Db],Qb);F([Fb],Rb);F([Hb],Sb);F([Gb],Tb);J=w[G(Ab)];var L=J.indexOf(Ub);if(L!=-1){x=Number(J.substring(L+1));J=J.substring(0,L)}K=J+Vb}catch(a){return}}var M;function N(){if(!r){r=true;if(!__gwt_stylesLoaded[Wb]){var a=m.createElement(Xb);__gwt_stylesLoaded[Wb]=a;a.setAttribute(Yb,Zb);a.setAttribute($b,s+Wb);m.getElementsByTagName(_b)[0].appendChild(a)}B();if(m.removeEventListener){m.removeEventListener(ac,N,false)}if(M){clearInterval(M)}}}
if(m.addEventListener){m.addEventListener(ac,function(){I();N()},false)}var M=setInterval(function(){if(/loaded|complete/.test(m.readyState)){I();N()}},50);n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:R,millis:(new Date).getTime(),type:X});n&&n({moduleName:P,sessionId:o,subSystem:Q,evtGroup:Lb,millis:(new Date).getTime(),type:S});m.write(bc)}
>>>>>>> refs/remotes/origin/design
register();
