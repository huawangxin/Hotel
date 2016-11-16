<%@ page pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
		<script src="hotel/js/validation-framework.js"></script>
		<a href="${ctx}/loginMessage3.jsp">返回服务界面</a><br>
		<div align="center">
			预定客户入住
		<form id="form14" name="form14" method="post"
			action="${ctx}/servlet/changeHome"
			onsubmit="return doValidate(this)">
			<table width="400" border="0">
				<tr>
					<td width="120">
						现住房间号：
					</td>
					<td width="200">
						<label>
							<input name="id1" type="text" id="id1" size="20" />
						</label>
					</td>
					</tr>
					<tr>
					<td width="120">
						换入房间号：
					</td>
					<td width="200">
						<label>
							<input name="id2" type="text" id="id2" size="20" />
						</label>
					</td>
					</tr>
					<tr>
					<td width="120">
						身份证号：
					</td>
					<td width="200">
						<label>
							<input name="idcard" type="text" id="idcard" size="20" />
						</label>
					</td>
					</tr>
					<tr>
					<td>
						<label>
							<input type="submit" name="submit" id="submit" value="提交" />
						</label>
					</td>
					<td>
						<label>
							<input type="reset" name="reset" id="reset" value="重置" />
						</label>
					</td>
				</tr>
			</table>
		</form>
</div>
<%@ include file="/footer.htm"%>

