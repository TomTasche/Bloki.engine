function submit(){var L='',hc='\n-',sb='" for "gwt:onLoadErrorFn"',qb='" for "gwt:onPropertyErrorFn"',Wb='"<script src=\\"',eb='"><\/script>',V='#',gc=');',$b='-\n',ic='-><\/scr',Xb='.cache.js\\"><\/scr" + "ipt>"',X='/',Hb='0224711B1CAB603BEAED5D25ED6A3E08',Ib='2DEE44A96B4BA53E19F98CF6432D78E0',Jb='2EBC7CBCFD9190C665E2249CE06B241F',Kb='3E70B37C41FD0498BD47DDE76F9A370D',Lb='4E83B88FE99292326F98ADA8E5EB4AB0',Mb='9477F62E2F3442471226541812710620',Nb=':',kb='::',Yb='<scr',db='<script id="',nb='=',W='?',pb='Bad handler "',Eb='Cross-site hosted mode not yet implemented. See issue ',Ub='DOMContentLoaded',fb='SCRIPT',cb='__gwt_marker_submit',gb='base',$='baseUrl',P='begin',O='bootstrap',Z='clear.cache.gif',mb='content',fc='document.write(',U='end',bc='evtGroup: "loadExternalRefs", millis:(new Date()).getTime(),',dc='evtGroup: "moduleStartup", millis:(new Date()).getTime(),',Bb='gecko',Cb='gecko1_8',Q='gwt.codesvr=',R='gwt.hosted=',S='gwt.hybrid',Ob='gwt/clean/clean.css',rb='gwt:onLoadErrorFn',ob='gwt:onPropertyErrorFn',lb='gwt:property',Tb='head',Sb='href',Fb='http://code.google.com/p/google-web-toolkit/issues/detail?id=2079',Ab='ie6',zb='ie8',yb='ie9',Y='img',jc='ipt>',Zb='ipt><!-',Pb='link',Vb='loadExternalRefs',hb='meta',ac='moduleName:"submit", sessionId:window.__gwtStatsSessionId, subSystem:"startup",',T='moduleStartup',xb='msie',ib='name',ub='opera',Qb='rel',wb='safari',_='script',Gb='selectingPermutation',N='startup',Rb='stylesheet',M='submit',ab='submit.nocache.js',jb='submit::',cc='type: "end"});',ec='type: "moduleRequested"});',bb='undefined',Db='unknown',tb='user.agent',vb='webkit',_b='window.__gwtStatsEvent && window.__gwtStatsEvent({';var l=window,m=document,n=l.__gwtStatsEvent?function(a){return l.__gwtStatsEvent(a)}:null,o=l.__gwtStatsSessionId?l.__gwtStatsSessionId:null,p,q,r=L,s={},t=[],u=[],v=[],w=0,x,y;n&&n({moduleName:M,sessionId:o,subSystem:N,evtGroup:O,millis:(new Date).getTime(),type:P});if(!l.__gwt_stylesLoaded){l.__gwt_stylesLoaded={}}if(!l.__gwt_scriptsLoaded){l.__gwt_scriptsLoaded={}}function z(){var b=false;try{var c=l.location.search;return (c.indexOf(Q)!=-1||(c.indexOf(R)!=-1||l.external&&l.external.gwtOnLoad))&&c.indexOf(S)==-1}catch(a){}z=function(){return b};return b}
function A(){if(p&&q){p(x,M,r,w);n&&n({moduleName:M,sessionId:o,subSystem:N,evtGroup:T,millis:(new Date).getTime(),type:U})}}
function B(){function e(a){var b=a.lastIndexOf(V);if(b==-1){b=a.length}var c=a.indexOf(W);if(c==-1){c=a.length}var d=a.lastIndexOf(X,Math.min(c,b));return d>=0?a.substring(0,d+1):L}
function f(a){if(a.match(/^\w+:\/\//)){}else{var b=m.createElement(Y);b.src=a+Z;a=e(b.src)}return a}
function g(){var a=D($);if(a!=null){return a}return L}
function h(){var a=m.getElementsByTagName(_);for(var b=0;b<a.length;++b){if(a[b].src.indexOf(ab)!=-1){return e(a[b].src)}}return L}
function i(){var a;if(typeof isBodyLoaded==bb||!isBodyLoaded()){var b=cb;var c;m.write(db+b+eb);c=m.getElementById(b);a=c&&c.previousSibling;while(a&&a.tagName!=fb){a=a.previousSibling}if(c){c.parentNode.removeChild(c)}if(a&&a.src){return e(a.src)}}return L}
function j(){var a=m.getElementsByTagName(gb);if(a.length>0){return a[a.length-1].href}return L}
var k=g();if(k==L){k=h()}if(k==L){k=i()}if(k==L){k=j()}if(k==L){k=e(m.location.href)}k=f(k);r=k;return k}
function C(){var b=document.getElementsByTagName(hb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(ib),g;if(f){f=f.replace(jb,L);if(f.indexOf(kb)>=0){continue}if(f==lb){g=e.getAttribute(mb);if(g){var h,i=g.indexOf(nb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=L}s[f]=h}}else if(f==ob){g=e.getAttribute(mb);if(g){try{y=eval(g)}catch(a){alert(pb+g+qb)}}}else if(f==rb){g=e.getAttribute(mb);if(g){try{x=eval(g)}catch(a){alert(pb+g+sb)}}}}}}
function D(a){var b=s[a];return b==null?null:b}
function E(a,b){var c=v;for(var d=0,e=a.length-1;d<e;++d){c=c[a[d]]||(c[a[d]]=[])}c[a[e]]=b}
function F(a){var b=u[a](),c=t[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(y){y(a,d,b)}throw null}
u[tb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(function(){return b.indexOf(ub)!=-1}())return ub;if(function(){return b.indexOf(vb)!=-1}())return wb;if(function(){return b.indexOf(xb)!=-1&&m.documentMode>=9}())return yb;if(function(){return b.indexOf(xb)!=-1&&m.documentMode>=8}())return zb;if(function(){var a=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(a&&a.length==3)return c(a)>=6000}())return Ab;if(function(){return b.indexOf(Bb)!=-1}())return Cb;return Db};t[tb]={gecko1_8:0,ie6:1,ie8:2,ie9:3,opera:4,safari:5};submit.onScriptLoad=function(a){submit.onScriptLoad=null;p=a;A()};if(z()){alert(Eb+Fb);return}C();B();n&&n({moduleName:M,sessionId:o,subSystem:N,evtGroup:O,millis:(new Date).getTime(),type:Gb});var G;try{E([yb],Hb);E([ub],Ib);E([Cb],Jb);E([zb],Kb);E([Ab],Lb);E([wb],Mb);G=v[F(tb)];var H=G.indexOf(Nb);if(H!=-1){w=Number(G.substring(H+1));G=G.substring(0,H)}}catch(a){return}var I;function J(){if(!q){q=true;if(!__gwt_stylesLoaded[Ob]){var a=m.createElement(Pb);__gwt_stylesLoaded[Ob]=a;a.setAttribute(Qb,Rb);a.setAttribute(Sb,r+Ob);m.getElementsByTagName(Tb)[0].appendChild(a)}A();if(m.removeEventListener){m.removeEventListener(Ub,J,false)}if(I){clearInterval(I)}}}
if(m.addEventListener){m.addEventListener(Ub,function(){J()},false)}var I=setInterval(function(){if(/loaded|complete/.test(m.readyState)){J()}},50);n&&n({moduleName:M,sessionId:o,subSystem:N,evtGroup:O,millis:(new Date).getTime(),type:U});n&&n({moduleName:M,sessionId:o,subSystem:N,evtGroup:Vb,millis:(new Date).getTime(),type:P});var K=Wb+r+G+Xb;m.write(Yb+Zb+$b+_b+ac+bc+cc+_b+ac+dc+ec+fc+K+gc+hc+ic+jc)}
submit();