/**
 * Created by Administrator on 2018/5/18.
 */

(function($){
    var main1 = echarts.init(document.getElementById('main1'));
    var main2 = echarts.init(document.getElementById('main2'));
    var main3 = echarts.init(document.getElementById('main3'));
    var main4 = echarts.init(document.getElementById('main4'));


    option = {
        grid: {
            left: '2%',
            right: '2%',
            bottom: '3%',
            containLabel: true
        },
        color:['#236FE4', '#042963','#E47923','#F3E93D','#27AECF'],
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:234, name:'联盟广告'},
                    {value:135, name:'视频广告'},
                    {value:1548, name:'搜索引擎'}
                ]
            }
        ],
        graphic:[
            {
                id:'text1',
                type:'text',
                style:{
                    text:[
                        "测试数据1",
                        "测试数据2",
                        "测试数据3"
                    ].join("\n")
                }

            }
        ]
    };
    option2 = {
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        xAxis : [
            {
                type : 'category',
                data : ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'直接访问',
                type:'bar',
                barWidth: '60%',
                data:[10, 52, 200, 334, 390, 330, 220]
            }
        ]
    };
    option3 = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };
    option4 = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },
        toolbox: {
            feature: {
                restore: {},
                saveAsImage: {}
            }
        },
        color:['#236FE4', '#042963','#E47923','#F3E93D','#27AECF'],
        series: [
            {
                name: '业务指标',
                type: 'gauge',
                detail: {formatter:'{value}%'},
                data: [{value: 50, name: '完成率'}]
            }
        ]
    };

    $(document).ready(function(){
        main1.setOption(option);
        main2.setOption(option2);
        main3.setOption(option3);
        main4.setOption(option4);
        window.onresize = function(){
            main1.resize();
            main2.resize();
            main3.resize();
            main4.resize();
        }
    })

}(jQuery));

