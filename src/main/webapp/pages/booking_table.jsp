<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Js实现单元格点击变色效果</title>
	</head>
	<body>
		<script>
		var ObjTable = new Object();
		var prevbool = true;
		ObjTable.colCount=0;	//列数
		ObjTable.rowCount=0;	//行数
		ObjTable.Map = null;	//Table Map
		ObjTable.prevRow = -1;	//前一单元格的行号，默认为-1
		ObjTable.prevCol = -1;	//前一单元格的列号，默认为-1
		ObjTable.curRow=-1;	//当前行号，默认为-1
		ObjTable.curCol=-1;	//当前列号，默认为-1
		ObjTable.Element="TD";	//待操作元素的Tag Name
		ObjTable.Load = function(a_sID,a_sTagName){	//载入table
			var iRowCount=0, iColCount=0, i, j, m, n, iIndex=0, iCount;
			var sTable = document.getElementById(a_sID);
			if (sTable!=null) {	//设置tble属性
				var tableMap = [];
				iColCount=sTable.rows[0].cells.length;
				iRowCount = sTable.rows.length;	//获取总行数
				sTable.getElementsByTagName('tbody')[0].onclick=ObjTable_setFocus;	//监听click事件
				document.getElementsByTagName('body')[0].onkeydown=ObjTable_moveFocus;	//监听keydown事件
				ObjTable.colCount = iColCount;	//列数
				ObjTable.rowCount = iRowCount;	//行数
				var aCols=null, iCell;
				for (i=0; i<iRowCount; ++i) {
					aCols = new Array(iColCount);
					tableMap.push(aCols);
				}
				for (i=0; i<iRowCount; ++i) {
					iIndex=0;
						for (j=0; j<iColCount; j+=iCell.colSpan) {
							if (tableMap[i][j]==null) {
								iCell = sTable.rows[i].cells[iIndex++];
									for(m=i; m<i+iCell.rowSpan; ++m) {
										for(n=j; n<j+iCell.colSpan; ++n) {tableMap[m][n] = i+','+j;}
									}
								tableMap[i][j] = iCell;
							}
						}
				}
				ObjTable.Map = tableMap;//table map结束
			}
		};
		//鼠标点击设置焦点
		var iCurRow,iCurCol;
		function ObjTable_setFocus(event){
			var e = event || window.event;
			var obj = e.target || e.srcElement, oParent = obj.parentNode;
			var iCurRow = ObjTable.curRow, iCurCol = ObjTable.curCol;
			if (prevbool==true){var iCurRow = ObjTable.curRow, iCurCol = ObjTable.curCol;}
			else{ObjTable.prevRow = iCurRow;ObjTable.prevCol = iCurCol;}
			RecallFocus(ObjTable);
			var oPrevNode = ObjTable.getNode(ObjTable.prevRow,ObjTable.prevCol);
			var iColCount = ObjTable.colCount;
			var aMaps = ObjTable.Map;
			if (oParent.tagName.toUpperCase() != "TR") {return;}
			iCurRow = oParent.rowIndex;
			for (var i=0; i<iColCount; i++){
				if (aMaps[iCurRow][i]==obj) {
					iCurCol = i;
					break;
				}
			}
			//设置结点的位置
			ObjTable.curRow = iCurRow;
			ObjTable.curCol = iCurCol;
			//记录前一个节点的位置
			ObjTable.prevRow = iCurRow;
			ObjTable.prevCol = iCurCol;
			obj.focus();
			obj.bgColor ="#336699";
			obj.style.color="#FFFFFF";
			prevbool=true;
		}
		//移动焦点
		function ObjTable_moveFocus(event) {
			//获取当前结点
			var e = event || window.event;
			var oNode = e.target || e.srcElement;
			var oNext = null;
			switch (e.keyCode) {
				case 37://左键 2
				oNext = CTable_getNextNode(2);
				break;
				case 38://上键 0
				oNext = CTable_getNextNode(0);
				break;
				case 13://回车键
				case 39://右键 3
				oNext = CTable_getNextNode(3);
				break;
				case 40://下键 1
				oNext = CTable_getNextNode(1);
				break;
			}
			//改变背景色
			if (oNext) {
				oNext.focus();
				oNext.bgColor="#336699";
				oNext.style.color="#FFFFFF";
			}
		}
		//获取指定行、列号的单元格
		ObjTable.getNode = function(a_iRow,a_iCol) {
			//如果行号或列号小于零，则返回null
			if (a_iRow<0 || a_iCol<0) {return null;}
			//初始化数据
			var oNode=null;
			var aMaps = ObjTable.Map, aTemps=null;
			var iRow = a_iRow, iCol=a_iCol;
			var sTemp="";
			//获取结点
			while(true) {
				oNode = aMaps[iRow][iCol];
				sTemp=typeof(oNode);
				if (sTemp.toLowerCase()=="string") {
					aTemps=oNode.split(",");
					iRow = aTemps[0];
					iCol = aTemps[1];
				}
				else {break;}
			}
			return oNode;	//函数返回值
		}
		//获取一下结点
		function CTable_getNextNode(a_key) {
			var oNode = null;
			var iCol = ObjTable.curCol ,iRow=ObjTable.curRow;
			var iRowCount = ObjTable.rowCount, iColCount=ObjTable.colCount;
			var aMaps = ObjTable.Map, aTemps=null;
			var iCurCol=iCol, iCurRow = iRow, iTemp;
			var sTemp="", sStr="";
			oNode = aMaps[iRow][iCol];
			if (typeof(oNode)=="string") {
				aTemps = oNode.split(",");
				iCurRow = aTemps[0];
				iCurCol = aTemps[1];
			}
			while (true) {
				switch(a_key) {
					case 0:
					iRow--;
					break;
					case 1:
					iRow++;
					break;
					case 2:
					iCol--;
					if (iCol<0) {
						iCol = iColCount-1;
						iRow--;
					}
					break;
					case 3:
					iCol++;
					if (iCol>=iColCount) {
						iRow++;
						iCol=0;
					}
					break;
				}
				if (iRow<0) {iRow=iRowCount-1;}
				if (iRow>=iRowCount) {iRow=0;}
				if ((iCurRow == iRow) && (iCurCol == iCol)) {continue;}
				oNext = aMaps[iRow][iCol];
				sTemp=typeof(oNext);
				if (sTemp.toLowerCase()=="string") {
					aTemps=oNext.split(",");
					if ((iCurRow!=aTemps[0]) || (iCurCol!=aTemps[1])){break;}
						continue;
				}
				break;
			}; //end CTable.get Next Node
			switch(a_key) {
				case 0://上
				case 1://下
				if (oNext.colSpan>1) {
					ObjTable.prevCol = CTable.curCol;
					ObjTable.prevRow = ObjTable.curRow;
					ObjTable.curRow = iRow;
				}
				else {
					ObjTable.prevCol = ObjTable.curCol;
					ObjTable.prevRow = ObjTable.curRow;
					ObjTable.curCol = iCol;
					ObjTable.curRow = iRow;
				}
				break;
				case 2://左
				case 3://右
				if (oNext.rowSpan>1) {
					ObjTable.prevCol = ObjTable.curCol;
					ObjTable.curCol = iCol;
					iTemp = ObjTable.curRow;
					ObjTable.curRow = iRow;
					ObjTable.prevRow = iTemp;
				}
				else {
					ObjTable.prevCol = ObjTable.curCol;
					ObjTable.prevRow = ObjTable.curRow;
					ObjTable.curCol = iCol;
					ObjTable.curRow = iRow;
				}
				break;
			}
			RecallFocus(ObjTable);
			prevbool=false;
			iCurRow=ObjTable.curCol;
			iCurCol=ObjTable.curRow;
			return oNext;
		}
		function RecallFocus(c){
			var oPrev = ObjTable.getNode(c.prevRow,c.prevCol);
			if (oPrev) {
				oPrev.bgColor="#FFFFFF";
				oPrev.style.color="#000000";
			}
		}
		//窗体载入函数
		window.onload=function() {ObjTable.Load("table1","TD");};
		</script>
		
		<table width="30%" class="table_time_number">
		<tr>
		<td width="15%">日期</td>
		<td width="10%">
		<select name="日期">
		<option value="time1">2016-08-01</option>
		<option value="time2">2016-08-02</option>
		<option value="time3">2016-08-03</option>
		</select>
		</td>
		<td width="15%">人数</td>
		<td width="10%">
		<select name="日期">
		<option value="p1">1</option>
		<option value="p2">2</option>
		<option value="p3">3</option>
		<option value="p4">4</option>
		</select>
		</tr>
		</table>
		
		<table id="table1" width="40%" border="0" cellpadding="1" cellspacing="1"
		bordercolor="#000000" bgcolor="#000000">
		<tr bgcolor="#FFFFFF">
		<td width="40%"></td>
		<td width="10%">羽01</td>
		<td width="10%">羽02</td>
		<td width="10%">羽03</td>
		<td width="10%">羽04</td>
		<td width="10%">羽05</td>
		<td width="10%">羽06</td>
		</tr>
		<tr bgcolor="#FFFFFF">
		<td>8:00-10:00</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr bgcolor="#FFFFFF">
		<td>10:00-12:00</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr bgcolor="#FFFFFF">
		<td>14:00-16:00</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		<tr bgcolor="#FFFFFF">
		<td>16:00-18:00</td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		</table>
		
		<button type="button">预约场地</button>
		
	</body>
</html>

