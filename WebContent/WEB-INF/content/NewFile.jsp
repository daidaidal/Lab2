<%@ taglib uri="/struts-tags" prefix="s"%> 
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- TemplateBeginEditable name="doctitle" -->
<title>welcome</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
<!-- TemplateEndEditable -->
<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background-color: #4E5869;
	margin: 0;
	padding: 0;
	color: #000;
	background-size:100% 100%;
	background-image: url(image/thelast.png);
	background-repeat: no-repeat;
	background-position: left top;
	background-attachment: fixed;
}

/* ~~ 元素/标签选择器 ~~ */
ul, ol, dl { /* 由于浏览器之间的差异，最佳做法是在列表中将填充和边距都设置为零。为了保持一致，您可以在此处指定需要的数值，也可以在列表所包含的列表项（LI、DT 和 DD）中指定需要的数值。请注意，除非编写一个更为具体的选择器，否则您在此处进行的设置将会层叠到 .nav 列表。 */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* 删除上边距可以解决边距会超出其包含的 div 的问题。剩余的下边距可以使 div 与后面的任何元素保持一定距离。 */
	padding-right: 15px;
	padding-left: 15px; /* 向 div 内的元素侧边（而不是 div 自身）添加填充可避免使用任何方框模型数学。此外，也可将具有侧边填充的嵌套 div 用作替代方法。 */
}
a img { /* 此选择器将删除某些浏览器中显示在图像周围的默认蓝色边框（当该图像包含在链接中时） */
	border: none;
}

/* ~~ 站点链接的样式必须保持此顺序，包括用于创建悬停效果的选择器组在内。 ~~ */
a:link {
	color:#414958;
	text-decoration: underline; /* 除非将链接设置成极为独特的外观样式，否则最好提供下划线，以便可从视觉上快速识别 */
}
a:visited {
	color: #4E5869;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* 此组选择器将为键盘导航者提供与鼠标使用者相同的悬停体验。 */
	text-decoration: none;
}

/* ~~ 此容器包含所有其它 div，并依百分比设定其宽度 ~~ */
.container {
	width: 80%;
	max-width: 1260px;/* 可能需要最大宽度，以防止此布局在大型显示器上过宽。这将使行长度更便于阅读。IE6 不遵循此声明。 */
	min-width: 780px;/* 可能需要最小宽度，以防止此布局过窄。这将使侧面列中的行长度更便于阅读。IE6 不遵循此声明。 */
	background-color: #FFF;
	margin: 0 auto; /* 侧边的自动值与宽度结合使用，可以将布局居中对齐。如果将 .container 宽度设置为 100%，则不需要此设置。 */
}

/* ~~ 标题未指定宽度。它将扩展到布局的完整宽度。标题包含一个图像占位符，该占位符应替换为您自己的链接徽标 ~~ */
.header {
	background-color: #6F7D94;
}

/* ~~ 这是布局信息。 ~~ 

1) 填充只会放置于 div 的顶部和/或底部。此 div 中的元素侧边会有填充。这样，您可以避免使用任何“方框模型数学”。请注意，如果向 div 自身添加任何侧边填充或边框，这些侧边填充或边框将与您定义的宽度相加，得出 *总计* 宽度。您也可以选择删除 div 中的元素的填充，并在该元素中另外放置一个没有任何宽度但具有设计所需填充的 div。

*/
.content {
	padding: 10px 0;
}

/* ~~ 此分组的选择器为 .content 区域中的列表提供了空间 ~~ */
.content ul, .content ol { 
	padding: 0 15px 15px 40px; /* 此填充反映上述标题和段落规则中的右填充。填充放置于下方可用于间隔列表中其它元素，置于左侧可用于创建缩进。您可以根据需要进行调整。 */
}

/* ~~ 脚注 ~~ */
.footer {
	padding: 10px 0;
	background-color: #6F7D94;
}

/* ~~ 其它浮动/清除类 ~~ */
.fltrt {  /* 此类可用于在页面中使元素向右浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: right;
	margin-left: 8px;
}
.fltlft { /* 此类可用于在页面中使元素向左浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* 如果从 #container 中删除或移出了 #footer，则可以将此类放置在 <br /> 或空 div 中，作为 #container 内最后一个浮动 div 之后的最终元素 */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
-->
</style></head>

<body>
    <h1>图书管理系统</h1>
<form id="form4" name="form4" method="post" action="Showbook">
      &nbsp;&nbsp;<input type="submit" value="show all book information" />
    </form>
    <form id="form5" name="form5" method="post" action="Showauthor">
      &nbsp;&nbsp;
      <p>
        <input type="submit" value="show all author information" />
      </p>
    </form>
<p>search book by author‘s name</p>
    <form id="form1" name="form1" method="post" action="Searcha">
      <p>
        <input type="text" name="authora.name" value="请输入作者名字" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value = "search"/>
      </p>
    </form>
<table width = "300" border = "1">
	<tr>
	<th>book name</th>
	<th>delete</th>
	</tr>
    <tr>
    <td>${test}</td>
    </tr>
  <s:iterator value = "a" var = "aa">
    <tr>
    <td><a href="ShowInf.action?books.isbn=${aa.isbn}">${aa.title}</a></td>
    <td><a href="Delete.action?bookd.isbn=${aa.isbn}">delete</a></td>
    </tr>
    </s:iterator>
    </table>
<form id="form2" name="form2" method="post" action="JtAddbook">
      &nbsp;
      <p>
        <input type="submit" value="add a new book" />
      </p>
</form>
    <form id="form3" name="form3" method="post" action="JtUpdate">
      &nbsp;&nbsp;<input type="submit" value="update book information" />
    </form>
    <p>&nbsp;</p>
</body>
</html>