//1,img的src属性会发起GET请求，无法提取响应信息
//2,iframe,受限于同源策略
//3,script的src属性会发起GET请求，不受限于同源策略（JSONP）

//4,XMLHttpRequest(XHR)

//IE6中
//if (window.XMLHttpRequest === undefined) {
//    window.XMLHttpRequest = function() {
//        try {
//            return new ActiveXObject("Msxml2.XMLHTTP.6.0");
//        } catch (e1) {
//            try {
//                return new ActiveXObject("Msxml2.XMLHTTP.3.0");
//            } catch (e2) {
//                throw new Error("XMLHttpRequest is not supported");
//            }
//        }
//    }
//}

//Http Get Demo
var request = new XMLHttpRequest();
request.open("GET", "/service");
//request.setRequestHeader("Content-Type", "text/plain");//默认是这个类型
request.onreadystatechange = function() {
    //请求完成
    if (request.readyState === 4 && request.status === 200) {
        alert(request.responseText);
    }
};
request.send(null);

//Http Post Demo
var data = "p=1&b=2";//"application/x-www-form-urlencoded"
request = new XMLHttpRequest();
request.open("POST", "/service");
request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//表单编码的请求
//request.setRequestHeader("Content-Type", "application/json");//JSON编码的请求
//JSON.stringify(data);//对象转字符串
request.onreadystatechange = function() {
    //请求完成
    if (request.readyState === 4 && request.status === 200) {
        alert(request.responseText);
        var type = request.getResponseHeader("Content-Type");
        if (type.indexOf("xml") !== -1 && request.responseXML) console.log(request.responseXML);//Document对象响应
        else if (type === "application/json") console.log(JSON.parse(request.responseText));//JSON响应 (JSON字符串转对象)
    }
};
request.send(data);
