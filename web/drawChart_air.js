// temData = [
//     {time: "2014-06-17 10:54:01", r0: 63},
//     {time: "2014-06-17 11:09:01", r0: 45},
//     {time: "2014-06-17 11:24:01", r0: 37},
//     {time: "2014-06-17 11:39:01", r0: 42}
// ];

var count = 0;

function aqiPoint(p_time, p_val)
{
    var val_num = parseInt(p_val.split("&")[3]);
    this.time = p_time;
    this.r0 = val_num;
}


function insAndDraw(responseText)
{
    var wrapper = document.getElementById("chartwrapper");
    wrapper.innerHTML = "";
    var aqi_tmp = new aqiPoint(getDate(), responseText);
    aqiData.push(aqi_tmp);
    count++;
    if (count > 20)
    {
        aqiData.splice(0, 1);
    }

    var newChart1 = document.createElement("div");
    newChart1.setAttribute("id", "myChart1");
    newChart1.setAttribute("style", "display:inline-block;width: 400px;background-color:whitesmoke;");
    newChart1.setAttribute("class", "chart");
    wrapper.appendChild(newChart1);
    Morris.Line({
        element: "myChart1",
        data: aqiData,
        xkey: "time",
        ykeys: aqiIDs,
        labels: aqiNames,
        hideHover: true,
        hoverOpacity: 0,
        pointSize: 3
    });


}

function getDate()
{
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9)
    {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9)
    {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + date.getHours() + seperator2 + date.getMinutes()
        + seperator2 + date.getSeconds();
    return currentdate;
}

Morris.Line({
    element: "myChart1",
    data: aqiData,
    xkey: "time",
    ykeys: aqiIDs,
    labels: aqiNames
});
