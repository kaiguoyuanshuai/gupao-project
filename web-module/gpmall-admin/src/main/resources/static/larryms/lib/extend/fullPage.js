(function(n,t){"use strict";if(window.layui&&layui.define){layui.define("jquery",function(e){layui.link(layui.cache.extendSkin+"/fullpage/fullPage.css");e("fullpage",t(layui.$,n,n.document,n.Math))})}else if(typeof define==="function"&&define.amd){define(["jquery"],function(e){return t(e,n,n.document,n.Math)})}else if(typeof exports==="object"&&exports){module.exports=t(require("jquery"),n,n.document,n.Math)}else{t(jQuery,n,n.document,n.Math)}})(typeof window!=="undefined"?window:this,function(Kn,_n,Qn,$n,Gn){"use strict";if(!_n.larrymsExtend){return false}var Jn="fullpage-wrapper";var Zn="."+Jn;var e="fp-scrollable";var n="."+e;var et="fp-responsive";var nt="fp-notransition";var tt="fp-destroyed";var it="fp-enabled";var ot="fp-viewing";var at="active";var rt="."+at;var lt="fp-completely";var st="."+lt;var ft=".section";var ct="fp-section";var ut="."+ct;var dt=ut+rt;var vt=ut+":first";var ht=ut+":last";var pt="fp-tableCell";var gt="."+pt;var mt="fp-auto-height";var t=".fp-auto-height";var yt="fp-normal-scroll";var i=".fp-normal-scroll";var wt="fp-nav";var St="#"+wt;var bt="fp-tooltip";var xt="."+bt;var Ct="fp-show-active";var Tt=".slide";var kt="fp-slide";var Lt="."+kt;var At=Lt+rt;var Ot="fp-slides";var It="."+Ot;var Et="fp-slidesContainer";var Mt="."+Et;var Bt="fp-table";var Rt="fp-slidesNav";var zt="."+Rt;var Ht=zt+" a";var o="fp-controlArrow";var Pt="."+o;var Dt="fp-prev";var a="."+Dt;var qt=o+" "+Dt;var Ft=Pt+a;var r="fp-next";var l="."+r;var jt=o+" "+r;var Vt=Pt+l;var Yt=Kn(_n);var Nt=Kn(Qn);Kn.fn.fullpage=function(m){if(Kn("html").hasClass(it)){Un();return}var u=Kn("html, body");var y=Kn("body");var e=Kn.fn.fullpage;m=Kn.extend({menu:false,anchors:[],lockAnchors:false,navigation:false,navigationPosition:"right",navigationTooltips:[],showActiveTooltip:false,slidesNavigation:false,slidesNavPosition:"bottom",scrollBar:false,hybrid:false,css3:true,scrollingSpeed:700,autoScrolling:true,fitToSection:true,fitToSectionDelay:1e3,easing:"easeInOutCubic",easingcss3:"ease",loopBottom:false,loopTop:false,loopHorizontal:true,continuousVertical:false,continuousHorizontal:false,scrollHorizontally:false,interlockedSlides:false,dragAndMove:false,offsetSections:false,resetSliders:false,fadingEffect:false,normalScrollElements:null,scrollOverflow:false,scrollOverflowReset:false,scrollOverflowHandler:Kn.fn.fp_scrolloverflow?Kn.fn.fp_scrolloverflow.iscrollHandler:null,scrollOverflowOptions:null,touchSensitivity:5,normalScrollElementTouchThreshold:5,bigSectionsDestination:null,keyboardScrolling:true,animateAnchor:true,recordHistory:true,controlArrows:true,controlArrowColor:"#fff",verticalCentered:true,sectionsColor:[],paddingTop:0,paddingBottom:0,fixedElements:null,responsive:0,responsiveWidth:0,responsiveHeight:0,responsiveSlides:false,parallax:false,parallaxOptions:{type:"reveal",percentage:62,property:"translate"},sectionSelector:ft,slideSelector:Tt,afterLoad:null,onLeave:null,afterRender:null,afterResize:null,afterReBuild:null,afterSlideLoad:null,onSlideLeave:null,afterResponsive:null,lazyLoading:true},m);var l=false;var t=navigator.userAgent.match(/(iPhone|iPod|iPad|Android|playbook|silk|BlackBerry|BB10|Windows Phone|Tizen|Bada|webOS|IEMobile|Opera Mini)/);var i="ontouchstart"in _n||navigator.msMaxTouchPoints>0||navigator.maxTouchPoints;var o=Kn(this);var w=Yt.height();var s=false;var n=true;var S;var a;var b=true;var d=[];var v;var r;var f={};f.m={up:true,down:true,left:true,right:true};f.k=Kn.extend(true,{},f.m);var c=Pn();var h={touchmove:"ontouchmove"in _n?"touchmove":c.move,touchstart:"ontouchstart"in _n?"touchstart":c.down};var p;var g='a[href], area[href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), button:not([disabled]), iframe, object, embed, [tabindex="0"], [contenteditable]';var x;var C;var T;var k;var L;var A;var O=Kn.extend(true,{},m);Un();Kn.extend(Kn.easing,{easeInOutCubic:function(e,n,t,i,o){if((n/=o/2)<1)return i/2*n*n*n+t;return i/2*((n-=2)*n*n+2)+t}});function I(e,n){if(!e){Fn(0)}Xn("autoScrolling",e,n);var t=Kn(dt);if(m.autoScrolling&&!m.scrollBar){u.css({overflow:"hidden",height:"100%"});E(O.recordHistory,"internal");o.css({"-ms-touch-action":"none","touch-action":"none"});if(t.length){Fn(t.position().top)}}else{u.css({overflow:"visible",height:"initial"});E(false,"internal");o.css({"-ms-touch-action":"","touch-action":""});if(t.length){u.scrollTop(t.position().top)}}}function E(e,n){Xn("recordHistory",e,n)}function M(e,n){Xn("scrollingSpeed",e,n)}function B(e,n){Xn("fitToSection",e,n)}function R(e){m.lockAnchors=e}function z(e){if(e){Mn();Bn()}else{En();Rn()}}function H(t,e){if(typeof e!=="undefined"){e=e.replace(/ /g,"").split(",");Kn.each(e,function(e,n){Vn(t,n,"m")})}else{Vn(t,"all","m");if(t){z(true);zn()}else{z(false);Hn()}}}function P(t,e){if(typeof e!=="undefined"){e=e.replace(/ /g,"").split(",");Kn.each(e,function(e,n){Vn(t,n,"k")})}else{Vn(t,"all","k");m.keyboardScrolling=t}}function D(){var e=Kn(dt).prev(ut);if(!e.length&&(m.loopTop||m.continuousVertical)){e=Kn(ut).last()}if(e.length){Oe(e,null,true)}}function q(){var e=Kn(dt).next(ut);if(!e.length&&(m.loopBottom||m.continuousVertical)){e=Kn(ut).first()}if(e.length){Oe(e,null,false)}}function F(e,n){M(0,"internal");j(e,n);M(O.scrollingSpeed,"internal")}function j(e,n){var t=Sn(e);if(typeof n!=="undefined"){xn(e,n)}else if(t.length>0){Oe(t)}}function V(e){Te("right",e)}function Y(e){Te("left",e)}function N(e){if(o.hasClass(tt)){return}s=true;w=Yt.height();Kn(ut).each(function(){var e=Kn(this).find(It);var n=Kn(this).find(Lt);if(m.verticalCentered){Kn(this).find(gt).css("height",yn(Kn(this))+"px")}Kn(this).css("height",w+"px");if(n.length>1){tn(e,e.find(At))}});if(m.scrollOverflow){p.createScrollBarForAll()}var n=Kn(dt);var t=n.index(ut);if(t){F(t+1)}s=false;Kn.isFunction(m.afterResize)&&e&&m.afterResize.call(o);Kn.isFunction(m.afterReBuild)&&!e&&m.afterReBuild.call(o)}function X(e){var n=y.hasClass(et);if(e){if(!n){I(false,"internal");B(false,"internal");Kn(St).hide();y.addClass(et);Kn.isFunction(m.afterResponsive)&&m.afterResponsive.call(o,e)}}else if(n){I(O.autoScrolling,"internal");B(O.autoScrolling,"internal");Kn(St).show();y.removeClass(et);Kn.isFunction(m.afterResponsive)&&m.afterResponsive.call(o,e)}}if(Kn(this).length){e.version="2.9.7";e.setAutoScrolling=I;e.setRecordHistory=E;e.setScrollingSpeed=M;e.setFitToSection=B;e.setLockAnchors=R;e.setMouseWheelScrolling=z;e.setAllowScrolling=H;e.setKeyboardScrolling=P;e.moveSectionUp=D;e.moveSectionDown=q;e.silentMoveTo=F;e.moveTo=j;e.moveSlideRight=V;e.moveSlideLeft=Y;e.fitToSection=fe;e.reBuild=N;e.setResponsive=X;e.destroy=Yn;e.shared={afterRenderActions:oe};U();W()}function U(){if(m.css3){m.css3=In()}m.scrollBar=m.scrollBar||m.hybrid;K();_();H(true);I(m.autoScrolling,"internal");fn();On();if(Qn.readyState==="complete"){je()}Yt.on("load",je)}function W(){Yt.on("scroll",se).on("hashchange",Ve).blur(Qe).resize(sn);Nt.keydown(Ne).keyup(Ue).on("click touchstart",St+" a",$e).on("click touchstart",Ht,Ge).on("click",xt,Xe);Kn(ut).on("click touchstart",Pt,_e);if(m.normalScrollElements){Nt.on("mouseenter touchstart",m.normalScrollElements,function(){H(false)});Nt.on("mouseleave touchend",m.normalScrollElements,function(){H(true)})}}function K(){var e=o.find(m.sectionSelector);if(!m.anchors.length){m.anchors=e.filter("[data-anchor]").map(function(){return Kn(this).data("anchor").toString()}).get()}if(!m.navigationTooltips.length){m.navigationTooltips=e.filter("[data-tooltip]").map(function(){return Kn(this).data("tooltip").toString()}).get()}}function _(){o.css({height:"100%",position:"relative"});o.addClass(Jn);Kn("html").addClass(it);w=Yt.height();o.removeClass(tt);J();Kn(ut).each(function(e){var n=Kn(this);var t=n.find(Lt);var i=t.length;n.data("fp-styles",n.attr("style"));$(n,e);G(n,e);if(i>0){Q(n,t,i)}else{if(m.verticalCentered){mn(n)}}});if(m.fixedElements&&m.css3){Kn(m.fixedElements).appendTo(y)}if(m.navigation){ee()}ne();if(m.scrollOverflow){p=m.scrollOverflowHandler.init(m)}else{oe()}}function Q(e,n,t){var i=t*100;var o=100/t;n.wrapAll('<div class="'+Et+'" />');n.parent().wrap('<div class="'+Ot+'" />');e.find(Mt).css("width",i+"%");if(t>1){if(m.controlArrows){Z(e)}if(m.slidesNavigation){Tn(e,t)}}n.each(function(e){Kn(this).css("width",o+"%");if(m.verticalCentered){mn(Kn(this))}});var a=e.find(At);if(a.length&&(Kn(dt).index(ut)!==0||Kn(dt).index(ut)===0&&a.index()!==0)){qn(a,"internal")}else{n.eq(0).addClass(at)}}function $(e,n){if(!n&&Kn(dt).length===0){e.addClass(at)}r=Kn(dt);e.css("height",w+"px");if(m.paddingTop){e.css("padding-top",m.paddingTop)}if(m.paddingBottom){e.css("padding-bottom",m.paddingBottom)}if(typeof m.sectionsColor[n]!=="undefined"){e.css("background-color",m.sectionsColor[n])}if(typeof m.anchors[n]!=="undefined"){e.attr("data-anchor",m.anchors[n])}}function G(e,n){if(typeof m.anchors[n]!=="undefined"){if(e.hasClass(at)){hn(m.anchors[n],n)}}if(m.menu&&m.css3&&Kn(m.menu).closest(Zn).length){Kn(m.menu).appendTo(y)}}function J(){o.find(m.sectionSelector).addClass(ct);o.find(m.slideSelector).addClass(kt)}function Z(e){e.find(It).after('<div class="'+qt+'"></div><div class="'+jt+'"></div>');if(m.controlArrowColor!="#fff"){e.find(Vt).css("border-color","transparent transparent transparent "+m.controlArrowColor);e.find(Ft).css("border-color","transparent "+m.controlArrowColor+" transparent transparent")}if(!m.loopHorizontal){e.find(Ft).hide()}}function ee(){y.append('<div id="'+wt+'"><ul></ul></div>');var e=Kn(St);e.addClass(function(){return m.showActiveTooltip?Ct+" "+m.navigationPosition:m.navigationPosition});for(var n=0;n<Kn(ut).length;n++){var t="";if(m.anchors.length){t=m.anchors[n]}var i='<li><a href="#'+t+'"><span></span></a>';var o=m.navigationTooltips[n];if(typeof o!=="undefined"&&o!==""){i+='<div class="'+bt+" "+m.navigationPosition+'">'+o+"</div>"}i+="</li>";e.find("ul").append(i)}Kn(St).css("margin-top","-"+Kn(St).height()/2+"px");Kn(St).find("li").eq(Kn(dt).index(ut)).find("a").addClass(at)}function ne(){o.find('iframe[src*="youtube.com/embed/"]').each(function(){te(Kn(this),"enablejsapi=1")})}function te(e,n){var t=e.attr("src");e.attr("src",t+ie(t)+n)}function ie(e){return!/\?/.test(e)?"?":"&"}function oe(){var e=Kn(dt);e.addClass(lt);He(e);Pe(e);if(m.scrollOverflow){m.scrollOverflowHandler.afterLoad()}if(ae()){Kn.isFunction(m.afterLoad)&&m.afterLoad.call(e,e.data("anchor"),e.index(ut)+1)}Kn.isFunction(m.afterRender)&&m.afterRender.call(o)}function ae(){var e=Sn(Ye().section);return!e||e.length&&e.index()===r.index()}var re=false;var le=0;function se(){var e;if(!m.autoScrolling||m.scrollBar){var n=Yt.scrollTop();var t=ue(n);var i=0;var o=n+Yt.height()/2;var a=y.height()-Yt.height()===n;var r=Qn.querySelectorAll(ut);if(a){i=r.length-1}else if(!n){i=0}else{for(var l=0;l<r.length;++l){var s=r[l];if(s.offsetTop<=o){i=l}}}if(ce(t)){if(!Kn(dt).hasClass(lt)){Kn(dt).addClass(lt).siblings().removeClass(lt)}}e=Kn(r).eq(i);if(!e.hasClass(at)){re=true;var f=Kn(dt);var c=f.index(ut)+1;var u=pn(e);var d=e.data("anchor");var v=e.index(ut)+1;var h=e.find(At);var p;var g;if(h.length){g=h.data("anchor");p=h.index()}if(b){e.addClass(at).siblings().removeClass(at);Kn.isFunction(m.onLeave)&&m.onLeave.call(f,c,v,u);Kn.isFunction(m.afterLoad)&&m.afterLoad.call(e,d,v);qe(f);He(e);Pe(e);hn(d,v-1);if(m.anchors.length){S=d}kn(p,g,d,v)}clearTimeout(k);k=setTimeout(function(){re=false},100)}if(m.fitToSection){clearTimeout(L);L=setTimeout(function(){if(m.fitToSection&&Kn(dt).outerHeight()<=w){fe()}},m.fitToSectionDelay)}}}function fe(){if(b){s=true;Oe(Kn(dt));s=false}}function ce(e){var n=Kn(dt).position().top;var t=n+Yt.height();if(e=="up"){return t>=Yt.scrollTop()+Yt.height()}return n<=Yt.scrollTop()}function ue(e){var n=e>le?"down":"up";le=e;Le=e;return n}function de(e){if(!f.m[e]){return}var n=e==="down"?q:D;if(m.scrollOverflow){var t=m.scrollOverflowHandler.scrollable(Kn(dt));var i=e==="down"?"bottom":"top";if(t.length>0){if(m.scrollOverflowHandler.isScrolled(i,t)){n()}else{return true}}else{n()}}else{n()}}function ve(e){var n=e.originalEvent;if(m.autoScrolling&&we(n)){e.preventDefault()}}var he=0;var pe=0;var ge=0;var me=0;function ye(e){var n=e.originalEvent;var t=Kn(n.target).closest(ut);if(we(n)){if(m.autoScrolling){e.preventDefault()}var i=Dn(n);ge=i.y;me=i.x;if(t.find(It).length&&$n.abs(pe-me)>$n.abs(he-ge)){if(!l&&$n.abs(pe-me)>Yt.outerWidth()/100*m.touchSensitivity){if(pe>me){if(f.m.right){V(t)}}else{if(f.m.left){Y(t)}}}}else if(m.autoScrolling&&b){if($n.abs(he-ge)>Yt.height()/100*m.touchSensitivity){if(he>ge){de("down")}else if(ge>he){de("up")}}}}}function we(e){return typeof e.pointerType==="undefined"||e.pointerType!="mouse"}function Se(e){var n=e.originalEvent;if(m.fitToSection){u.stop()}if(we(n)){var t=Dn(n);he=t.y;pe=t.x}}function be(e,n){var t=0;var i=e.slice($n.max(e.length-n,1));for(var o=0;o<i.length;o++){t=t+i[o]}return $n.ceil(t/n)}var xe=(new Date).getTime();function Ce(e){var n=(new Date).getTime();var t=Kn(st).hasClass(yt);if(m.autoScrolling&&!v&&!t){e=e||_n.event;var i=e.wheelDelta||-e.deltaY||-e.detail;var o=$n.max(-1,$n.min(1,i));var a=typeof e.wheelDeltaX!=="undefined"||typeof e.deltaX!=="undefined";var r=$n.abs(e.wheelDeltaX)<$n.abs(e.wheelDelta)||($n.abs(e.deltaX)<$n.abs(e.deltaY)||!a);if(d.length>149){d.shift()}d.push($n.abs(i));if(m.scrollBar){e.preventDefault?e.preventDefault():e.returnValue=false}var l=n-xe;xe=n;if(l>200){d=[]}if(b){var s=be(d,10);var f=be(d,70);var c=s>=f;if(c&&r){if(o<0){de("down")}else{de("up")}}}return false}if(m.fitToSection){u.stop()}}function Te(e,n){var t=typeof n==="undefined"?Kn(dt):n;var i=t.find(It);var o=i.find(Lt).length;if(!i.length||l||o<2){return}var a=i.find(At);var r=null;if(e==="left"){r=a.prev(Lt)}else{r=a.next(Lt)}if(!r.length){if(!m.loopHorizontal)return;if(e==="left"){r=a.siblings(":last")}else{r=a.siblings(":first")}}l=true;tn(i,r,e)}function ke(){Kn(At).each(function(){qn(Kn(this),"internal")})}var Le=0;function Ae(e){var n=e.position();var t=n.top;var i=n.top>Le;var o=t-w+e.outerHeight();var a=m.bigSectionsDestination;if(e.outerHeight()>w){if(!i&&!a||a==="bottom"){t=o}}else if(i||s&&e.is(":last-child")){t=o}Le=t;return t}function Oe(e,n,t){if(typeof e==="undefined"){return}var i=Ae(e);var o;var a;var r={element:e,callback:n,isMovementUp:t,dtop:i,yMovement:pn(e),anchorLink:e.data("anchor"),sectionIndex:e.index(ut),activeSlide:e.find(At),activeSection:Kn(dt),leavingSection:Kn(dt).index(ut)+1,localIsResizing:s};if(r.activeSection.is(e)&&!s||m.scrollBar&&Yt.scrollTop()===r.dtop&&!e.hasClass(mt)){return}if(r.activeSlide.length){o=r.activeSlide.data("anchor");a=r.activeSlide.index()}if(Kn.isFunction(m.onLeave)&&!r.localIsResizing){var l=r.yMovement;if(typeof t!=="undefined"){l=t?"up":"down"}if(m.onLeave.call(r.activeSection,r.leavingSection,r.sectionIndex+1,l)===false){return}}if(m.autoScrolling&&m.continuousVertical&&typeof r.isMovementUp!=="undefined"&&(!r.isMovementUp&&r.yMovement=="up"||r.isMovementUp&&r.yMovement=="down")){r=Me(r)}if(!r.localIsResizing){qe(r.activeSection)}if(m.scrollOverflow){m.scrollOverflowHandler.beforeLeave()}e.addClass(at).siblings().removeClass(at);He(e);if(m.scrollOverflow){m.scrollOverflowHandler.onLeave()}b=false;kn(a,o,r.anchorLink,r.sectionIndex);Ie(r);S=r.anchorLink;hn(r.anchorLink,r.sectionIndex)}function Ie(e){if(m.css3&&m.autoScrolling&&!m.scrollBar){var n="translate3d(0px, -"+$n.round(e.dtop)+"px, 0px)";wn(n,true);if(m.scrollingSpeed){clearTimeout(C);C=setTimeout(function(){Re(e)},m.scrollingSpeed)}else{Re(e)}}else{var t=Ee(e);Kn(t.element).animate(t.options,m.scrollingSpeed,m.easing).promise().done(function(){if(m.scrollBar){setTimeout(function(){Re(e)},30)}else{Re(e)}})}}function Ee(e){var n={};if(m.autoScrolling&&!m.scrollBar){n.options={top:-e.dtop};n.element=Zn}else{n.options={scrollTop:e.dtop};n.element="html, body"}return n}function Me(e){if(!e.isMovementUp){Kn(dt).after(e.activeSection.prevAll(ut).get().reverse())}else{Kn(dt).before(e.activeSection.nextAll(ut))}Fn(Kn(dt).position().top);ke();e.wrapAroundElements=e.activeSection;e.dtop=e.element.position().top;e.yMovement=pn(e.element);e.leavingSection=e.activeSection.index(ut)+1;e.sectionIndex=e.element.index(ut);return e}function Be(e){if(!e.wrapAroundElements||!e.wrapAroundElements.length){return}if(e.isMovementUp){Kn(vt).before(e.wrapAroundElements)}else{Kn(ht).after(e.wrapAroundElements)}Fn(Kn(dt).position().top);ke()}function Re(e){Be(e);Kn.isFunction(m.afterLoad)&&!e.localIsResizing&&m.afterLoad.call(e.element,e.anchorLink,e.sectionIndex+1);if(m.scrollOverflow){m.scrollOverflowHandler.afterLoad()}if(!e.localIsResizing){Pe(e.element)}e.element.addClass(lt).siblings().removeClass(lt);b=true;Kn.isFunction(e.callback)&&e.callback.call(this)}function ze(e,n){e.attr(n,e.data(n)).removeAttr("data-"+n)}function He(e){if(!m.lazyLoading){return}var n=Fe(e);var i;n.find("img[data-src], img[data-srcset], source[data-src], source[data-srcset], video[data-src], audio[data-src], iframe[data-src]").each(function(){i=Kn(this);Kn.each(["src","srcset"],function(e,n){var t=i.attr("data-"+n);if(typeof t!=="undefined"&&t){ze(i,n)}});if(i.is("source")){var e=i.closest("video").length?"video":"audio";i.closest(e).get(0).load()}})}function Pe(e){var n=Fe(e);n.find("video, audio").each(function(){var e=Kn(this).get(0);if(e.hasAttribute("data-autoplay")&&typeof e.play==="function"){e.play()}});n.find('iframe[src*="youtube.com/embed/"]').each(function(){var e=Kn(this).get(0);if(e.hasAttribute("data-autoplay")){De(e)}e.onload=function(){if(e.hasAttribute("data-autoplay")){De(e)}}})}function De(e){e.contentWindow.postMessage('{"event":"command","func":"playVideo","args":""}',"*")}function qe(e){var n=Fe(e);n.find("video, audio").each(function(){var e=Kn(this).get(0);if(!e.hasAttribute("data-keepplaying")&&typeof e.pause==="function"){e.pause()}});n.find('iframe[src*="youtube.com/embed/"]').each(function(){var e=Kn(this).get(0);if(/youtube\.com\/embed\//.test(Kn(this).attr("src"))&&!e.hasAttribute("data-keepplaying")){Kn(this).get(0).contentWindow.postMessage('{"event":"command","func":"pauseVideo","args":""}',"*")}})}function Fe(e){var n=e.find(At);if(n.length){e=Kn(n)}return e}function je(){var e=Ye();var n=e.section;var t=e.slide;if(n){if(m.animateAnchor){xn(n,t)}else{F(n,t)}}}function Ve(){if(!re&&!m.lockAnchors){var e=Ye();var n=e.section;var t=e.slide;var i=typeof S==="undefined";var o=typeof S==="undefined"&&typeof t==="undefined"&&!l;if(n&&n.length){if(n&&n!==S&&!i||o||!l&&a!=t){xn(n,t)}}}}function Ye(){var e;var n;var t=_n.location.hash;if(t.length){var i=t.replace("#","").split("/");var o=t.indexOf("#/")>-1;e=o?"/"+i[1]:decodeURIComponent(i[0]);var a=o?i[2]:i[1];if(a&&a.length){n=decodeURIComponent(a)}}return{section:e,slide:n}}function Ne(e){clearTimeout(A);var n=Kn(":focus");var t=e.which;if(t===9){Ze(e)}else if(!n.is("textarea")&&!n.is("input")&&!n.is("select")&&n.attr("contentEditable")!=="true"&&n.attr("contentEditable")!==""&&m.keyboardScrolling&&m.autoScrolling){var i=[40,38,32,33,34];if(Kn.inArray(t,i)>-1){e.preventDefault()}v=e.ctrlKey;A=setTimeout(function(){Je(e)},150)}}function Xe(){Kn(this).prev().trigger("click")}function Ue(e){if(n){v=e.ctrlKey}}function We(e){if(e.which==2){en=e.pageY;o.on("mousemove",nn)}}function Ke(e){if(e.which==2){o.off("mousemove")}}function _e(){var e=Kn(this).closest(ut);if(Kn(this).hasClass(Dt)){if(f.m.left){Y(e)}}else{if(f.m.right){V(e)}}}function Qe(){n=false;v=false}function $e(e){e.preventDefault();var n=Kn(this).parent().index();Oe(Kn(ut).eq(n))}function Ge(e){e.preventDefault();var n=Kn(this).closest(ut).find(It);var t=n.find(Lt).eq(Kn(this).closest("li").index());tn(n,t)}function Je(e){var n=e.shiftKey;if(!b&&[37,39].indexOf(e.which)<0){return}switch(e.which){case 38:case 33:if(f.k.up){D()}break;case 32:if(n&&f.k.up){D();break}case 40:case 34:if(f.k.down){q()}break;case 36:if(f.k.up){j(1)}break;case 35:if(f.k.down){j(Kn(ut).length)}break;case 37:if(f.k.left){Y()}break;case 39:if(f.k.right){V()}break;default:return}}function Ze(e){var n=e.shiftKey;var t=Kn(":focus");var i=Kn(dt);var o=i.find(At);var a=o.length?o:i;var r=a.find(g).not('[tabindex="-1"]');function l(e){e.preventDefault();return r.first().focus()}if(t.length){if(!t.closest(dt,At).length){t=l(e)}}else{l(e)}if(!n&&t.is(r.last())||n&&t.is(r.first())){e.preventDefault()}}var en=0;function nn(e){if(b){if(e.pageY<en&&f.m.up){D()}else if(e.pageY>en&&f.m.down){q()}}en=e.pageY}function tn(e,n,t){var i=e.closest(ut);var o={slides:e,destiny:n,direction:t,destinyPos:n.position(),slideIndex:n.index(),section:i,sectionIndex:i.index(ut),anchorLink:i.data("anchor"),slidesNav:i.find(zt),slideAnchor:An(n),prevSlide:i.find(At),prevSlideIndex:i.find(At).index(),localIsResizing:s};o.xMovement=gn(o.prevSlideIndex,o.slideIndex);if(!o.localIsResizing){b=false}if(m.onSlideLeave){if(!o.localIsResizing&&o.xMovement!=="none"){if(Kn.isFunction(m.onSlideLeave)){if(m.onSlideLeave.call(o.prevSlide,o.anchorLink,o.sectionIndex+1,o.prevSlideIndex,o.direction,o.slideIndex)===false){l=false;return}}}}n.addClass(at).siblings().removeClass(at);if(!o.localIsResizing){qe(o.prevSlide);He(n)}if(!m.loopHorizontal&&m.controlArrows){i.find(Ft).toggle(o.slideIndex!==0);i.find(Vt).toggle(!n.is(":last-child"))}if(i.hasClass(at)&&!o.localIsResizing){kn(o.slideIndex,o.slideAnchor,o.anchorLink,o.sectionIndex)}an(e,o,true)}function on(e){rn(e.slidesNav,e.slideIndex);if(!e.localIsResizing){Kn.isFunction(m.afterSlideLoad)&&m.afterSlideLoad.call(e.destiny,e.anchorLink,e.sectionIndex+1,e.slideAnchor,e.slideIndex);b=true;Pe(e.destiny)}l=false}function an(e,n,t){var i=n.destinyPos;if(m.css3){var o="translate3d(-"+$n.round(i.left)+"px, 0px, 0px)";cn(e.find(Mt)).css(jn(o));T=setTimeout(function(){t&&on(n)},m.scrollingSpeed,m.easing)}else{e.animate({scrollLeft:$n.round(i.left)},m.scrollingSpeed,m.easing,function(){t&&on(n)})}}function rn(e,n){e.find(rt).removeClass(at);e.find("li").eq(n).find("a").addClass(at)}var ln=w;function sn(){fn();if(t){var e=Kn(Qn.activeElement);if(!e.is("textarea")&&!e.is("input")&&!e.is("select")){var n=Yt.height();if($n.abs(n-ln)>20*$n.max(ln,n)/100){N(true);ln=n}}}else{clearTimeout(x);x=setTimeout(function(){N(true)},350)}}function fn(){var e=m.responsive||m.responsiveWidth;var n=m.responsiveHeight;var t=e&&Yt.outerWidth()<e;var i=n&&Yt.height()<n;if(e&&n){X(t||i)}else if(e){X(t)}else if(n){X(i)}}function cn(e){var n="all "+m.scrollingSpeed+"ms "+m.easingcss3;e.removeClass(nt);return e.css({"-webkit-transition":n,transition:n})}function un(e){return e.addClass(nt)}function dn(e,n){if(m.navigation){Kn(St).find(rt).removeClass(at);if(e){Kn(St).find('a[href="#'+e+'"]').addClass(at)}else{Kn(St).find("li").eq(n).find("a").addClass(at)}}}function vn(e){if(m.menu){Kn(m.menu).find(rt).removeClass(at);Kn(m.menu).find('[data-menuanchor="'+e+'"]').addClass(at)}}function hn(e,n){vn(e);dn(e,n)}function pn(e){var n=Kn(dt).index(ut);var t=e.index(ut);if(n==t){return"none"}if(n>t){return"up"}return"down"}function gn(e,n){if(e==n){return"none"}if(e>n){return"left"}return"right"}function mn(e){if(!e.hasClass(Bt)){var n=Kn('<div class="'+pt+'" />').height(yn(e));e.addClass(Bt).wrapInner(n)}}function yn(e){var n=w;if(m.paddingTop||m.paddingBottom){var t=e;if(!t.hasClass(ct)){t=e.closest(ut)}var i=parseInt(t.css("padding-top"))+parseInt(t.css("padding-bottom"));n=w-i}return n}function wn(e,n){if(n){cn(o)}else{un(o)}o.css(jn(e));setTimeout(function(){o.removeClass(nt)},10)}function Sn(e){var n=o.find(ut+'[data-anchor="'+e+'"]');if(!n.length){var t=typeof e!=="undefined"?e-1:0;n=Kn(ut).eq(t)}return n}function bn(e,n){var t=n.find(Lt+'[data-anchor="'+e+'"]');if(!t.length){e=typeof e!=="undefined"?e:0;t=n.find(Lt).eq(e)}return t}function xn(e,n){var t=Sn(e);if(!t.length)return;var i=bn(n,t);if(e!==S&&!t.hasClass(at)){Oe(t,function(){Cn(i)})}else{Cn(i)}}function Cn(e){if(e.length){tn(e.closest(It),e)}}function Tn(e,n){e.append('<div class="'+Rt+'"><ul></ul></div>');var t=e.find(zt);t.addClass(m.slidesNavPosition);for(var i=0;i<n;i++){t.find("ul").append('<li><a href="#"><span></span></a></li>')}t.css("margin-left","-"+t.width()/2+"px");t.find("li").first().find("a").addClass(at)}function kn(e,n,t,i){var o="";if(m.anchors.length&&!m.lockAnchors){if(e){if(typeof t!=="undefined"){o=t}if(typeof n==="undefined"){n=e}a=n;Ln(o+"/"+n)}else if(typeof e!=="undefined"){a=n;Ln(t)}else{Ln(t)}}On()}function Ln(e){if(m.recordHistory){location.hash=e}else{if(t||i){_n.history.replaceState(Gn,Gn,"#"+e)}else{var n=_n.location.href.split("#")[0];_n.location.replace(n+"#"+e)}}}function An(e){var n=e.data("anchor");var t=e.index();if(typeof n==="undefined"){n=t}return n}function On(){var e=Kn(dt);var n=e.find(At);var t=An(e);var i=An(n);var o=String(t);if(n.length){o=o+"-"+i}o=o.replace("/","-").replace("#","");var a=new RegExp("\\b\\s?"+ot+"-[^\\s]+\\b","g");y[0].className=y[0].className.replace(a,"");y.addClass(ot+"-"+o)}function In(){var e=Qn.createElement("p"),n,t={webkitTransform:"-webkit-transform",OTransform:"-o-transform",msTransform:"-ms-transform",MozTransform:"-moz-transform",transform:"transform"};Qn.body.insertBefore(e,null);for(var i in t){if(e.style[i]!==Gn){e.style[i]="translate3d(1px,1px,1px)";n=_n.getComputedStyle(e).getPropertyValue(t[i])}}Qn.body.removeChild(e);return n!==Gn&&n.length>0&&n!=="none"}function En(){if(Qn.addEventListener){Qn.removeEventListener("mousewheel",Ce,false);Qn.removeEventListener("wheel",Ce,false);Qn.removeEventListener("MozMousePixelScroll",Ce,false)}else{Qn.detachEvent("onmousewheel",Ce)}}function Mn(){var e="";var n;if(_n.addEventListener){n="addEventListener"}else{n="attachEvent";e="on"}var t="onwheel"in Qn.createElement("div")?"wheel":Qn.onmousewheel!==Gn?"mousewheel":"DOMMouseScroll";if(t=="DOMMouseScroll"){Qn[n](e+"MozMousePixelScroll",Ce,false)}else{Qn[n](e+t,Ce,false)}}function Bn(){o.on("mousedown",We).on("mouseup",Ke)}function Rn(){o.off("mousedown",We).off("mouseup",Ke)}function zn(){if(t||i){if(m.autoScrolling){y.off(h.touchmove).on(h.touchmove,ve)}Kn(Zn).off(h.touchstart).on(h.touchstart,Se).off(h.touchmove).on(h.touchmove,ye)}}function Hn(){if(t||i){if(m.autoScrolling){y.off(h.touchmove)}Kn(Zn).off(h.touchstart).off(h.touchmove)}}function Pn(){var e;if(_n.PointerEvent){e={down:"pointerdown",move:"pointermove"}}else{e={down:"MSPointerDown",move:"MSPointerMove"}}return e}function Dn(e){var n=[];n.y=typeof e.pageY!=="undefined"&&(e.pageY||e.pageX)?e.pageY:e.touches[0].pageY;n.x=typeof e.pageX!=="undefined"&&(e.pageY||e.pageX)?e.pageX:e.touches[0].pageX;if(i&&we(e)&&(m.scrollBar||!m.autoScrolling)){n.y=e.touches[0].pageY;n.x=e.touches[0].pageX}return n}function qn(e,n){M(0,"internal");if(typeof n!=="undefined"){s=true}tn(e.closest(It),e);if(typeof n!=="undefined"){s=false}M(O.scrollingSpeed,"internal")}function Fn(e){var n=$n.round(e);if(m.css3&&m.autoScrolling&&!m.scrollBar){var t="translate3d(0px, -"+n+"px, 0px)";wn(t,false)}else if(m.autoScrolling&&!m.scrollBar){o.css("top",-n)}else{u.scrollTop(n)}}function jn(e){return{"-webkit-transform":e,"-moz-transform":e,"-ms-transform":e,transform:e}}function Vn(t,e,i){if(e!=="all"){f[i][e]=t}else{Kn.each(Object.keys(f[i]),function(e,n){f[i][n]=t})}}function Yn(e){I(false,"internal");H(false);P(false);o.addClass(tt);clearTimeout(T);clearTimeout(C);clearTimeout(x);clearTimeout(k);clearTimeout(L);Yt.off("scroll",se).off("hashchange",Ve).off("resize",sn);Nt.off("keydown",Ne).off("keyup",Ue).off("click touchstart",St+" a").off("mouseenter",St+" li").off("mouseleave",St+" li").off("click touchstart",Ht).off("mouseover",m.normalScrollElements).off("mouseout",m.normalScrollElements);Kn(ut).off("click touchstart",Pt);clearTimeout(T);clearTimeout(C);if(e){Nn()}}function Nn(){Fn(0);o.find("img[data-src], source[data-src], audio[data-src], iframe[data-src]").each(function(){ze(Kn(this),"src")});o.find("img[data-srcset]").each(function(){ze(Kn(this),"srcset")});Kn(St+", "+zt+", "+Pt).remove();Kn(ut).css({height:"","background-color":"",padding:""});Kn(Lt).css({width:""});o.css({height:"",position:"","-ms-touch-action":"","touch-action":""});u.css({overflow:"",height:""});Kn("html").removeClass(it);y.removeClass(et);Kn.each(y.get(0).className.split(/\s+/),function(e,n){if(n.indexOf(ot)===0){y.removeClass(n)}});Kn(ut+", "+Lt).each(function(){if(m.scrollOverflowHandler){m.scrollOverflowHandler.remove(Kn(this))}Kn(this).removeClass(Bt+" "+at);Kn(this).attr("style",Kn(this).data("fp-styles"))});un(o);o.find(gt+", "+Mt+", "+It).each(function(){Kn(this).replaceWith(this.childNodes)});o.css({"-webkit-transition":"none",transition:"none"});u.scrollTop(0);var e=[ct,kt,Et];Kn.each(e,function(e,n){Kn("."+n).removeClass(n)})}function Xn(e,n,t){m[e]=n;if(t!=="internal"){O[e]=n}}function Un(){var e=["fadingEffect","continuousHorizontal","scrollHorizontally","interlockedSlides","resetSliders","responsiveSlides","offsetSections","dragAndMove","scrollOverflowReset","parallax"];if(Kn("html").hasClass(it)){Wn("error","Fullpage.js can only be initialized once and you are doing it multiple times!");return}if(m.continuousVertical&&(m.loopTop||m.loopBottom)){m.continuousVertical=false;Wn("warn","Option `loopTop/loopBottom` is mutually exclusive with `continuousVertical`; `continuousVertical` disabled")}if(m.scrollBar&&m.scrollOverflow){Wn("warn","Option `scrollBar` is mutually exclusive with `scrollOverflow`. Sections with scrollOverflow might not work well in Firefox")}if(m.continuousVertical&&(m.scrollBar||!m.autoScrolling)){m.continuousVertical=false;Wn("warn","Scroll bars (`scrollBar:true` or `autoScrolling:false`) are mutually exclusive with `continuousVertical`; `continuousVertical` disabled")}if(m.scrollOverflow&&!m.scrollOverflowHandler){m.scrollOverflow=false;Wn("error","The option `scrollOverflow:true` requires the file `scrolloverflow.min.js`. Please include it before fullPage.js.")}Kn.each(e,function(e,n){if(m[n]){Wn("warn","fullpage.js extensions require jquery.fullpage.extensions.min.js file instead of the usual jquery.fullpage.js. Requested: "+n)}});Kn.each(m.anchors,function(e,n){var t=Nt.find("[name]").filter(function(){return Kn(this).attr("name")&&Kn(this).attr("name").toLowerCase()==n.toLowerCase()});var i=Nt.find("[id]").filter(function(){return Kn(this).attr("id")&&Kn(this).attr("id").toLowerCase()==n.toLowerCase()});if(i.length||t.length){Wn("error","data-anchor tags can not have the same value as any `id` element on the site (or `name` element for IE).");i.length&&Wn("error",'"'+n+'" is is being used by another element `id` property');t.length&&Wn("error",'"'+n+'" is is being used by another element `name` property')}})}function Wn(e,n){console&&console[e]&&console[e]("fullPage: "+n)}}});