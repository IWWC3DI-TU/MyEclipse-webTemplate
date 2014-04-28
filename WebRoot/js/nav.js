// 菜单设置
var outlookbar=new outlook();
var t;
t=outlookbar.addtitle('测试管理','测试管理',1)
outlookbar.additem('测试管理',t,'profile.html')
outlookbar.additem('测试用例关联',t,'reset_info.php')

t=outlookbar.addtitle('任务管理','测试管理',1)
outlookbar.additem('任务启动',t,'../vbb/forumdisplay.php?s=320e689ffabc5daa0be8b02c284d9968&forumid=39')
outlookbar.additem('任务定时管理制定',t,'mailto:pobear@newmail.dlmu.edu.cn')

t=outlookbar.addtitle('报表管理','报表管理',1)
outlookbar.additem('动态测试数据报表',t,'report/report_all.jsp')
outlookbar.additem('差异性报告',t,'al_pass.php')
outlookbar.additem('报表告警设置',t,'modify.php')

t=outlookbar.addtitle('系统管理','系统管理',1)
outlookbar.additem('用户管理',t,'un_pass.php')
outlookbar.additem('应用系统测试任务管理',t,'al_pass.php')
outlookbar.additem('测试基线管理',t,'modify.php')

t=outlookbar.addtitle('退出系统','控制台',1)
outlookbar.additem('点击退出登录',t,'loginout.php')

