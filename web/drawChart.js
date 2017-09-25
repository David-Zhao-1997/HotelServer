// temData = [
//     {time: "2014-06-17 10:54:01", r0: 63},
//     {time: "2014-06-17 11:09:01", r0: 45},
//     {time: "2014-06-17 11:24:01", r0: 37},
//     {time: "2014-06-17 11:39:01", r0: 42}
// ];

var count = 0;

function temPoint(p_time, p_val)
{
    var val_num = parseInt(p_val.split("&")[1]);
    this.time = p_time;
    this.r0 = val_num;
}

function hudPoint(p_time, p_val)
{
    var val_num = parseInt(p_val.split("&")[2]);
    this.time = p_time;
    this.r0 = val_num;
}

function insAndDraw(responseText)
{
    var wrapper = document.getElementById("chartwrapper");

    var temChart = document.getElementById("myChart1");
    var hudChart = document.getElementById("myChart2");

    // wrapper.removeChild(temChart);
    // wrapper.removeChild(hudChart);
    wrapper.innerHTML = "";
    var tem_tmp = new temPoint(getDate(), responseText);
    var hud_tmp = new hudPoint(getDate(), responseText);
    temData.push(tem_tmp);
    hudData.push(hud_tmp);
    count++;
    if (count > 20)
    {
        temData.splice(0, 1);
        hudData.splice(0, 1);
    }

    var newChart1 = document.createElement("div");
    newChart1.setAttribute("id", "myChart1");
    newChart1.setAttribute("style", "display:inline-block;width: 400px;background-color:whitesmoke;");
    newChart1.setAttribute("class", "chart");
    wrapper.appendChild(newChart1);
    Morris.Line({
        element: "myChart1",
        data: temData,
        xkey: "time",
        ykeys: temIDs,
        labels: temNames,
        hideHover: true,
        hoverOpacity: 0,
        pointSize: 3
    });

    var newChart2 = document.createElement("div");
    newChart2.setAttribute("id", "myChart2");
    newChart2.setAttribute("style", "display:inline-block;width: 400px;background-color:whitesmoke;");
    newChart2.setAttribute("class", "chart");
    wrapper.appendChild(newChart2);
    Morris.Line({
        element: "myChart2",
        data: hudData,
        xkey: "time",
        ykeys: hudIDs,
        labels: hudNames,
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
    data: temData,
    xkey: "time",
    ykeys: temIDs,
    labels: temNames
});

Morris.Line({
    element: "myChart2",
    data: hudData,
    xkey: "time",
    ykeys: hudIDs,
    labels: hudNames
});