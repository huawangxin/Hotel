<%@ page pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
		<script src="hotel/js/validation-framework.js"></script>
		<div align="center">
			记录消费信息
		<form id="form15" name="form15" method="post"
			action="${ctx}/servlet/recordConsum"
			onsubmit="return doValidate(this)">
			<table width="491" border="0">
				<tr>
					<td width="87">
						客房号：
					</td>
					<td width="394">
						<label>
							<input name="id" type="text" id="id" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						消费类型：
					</td>
					<td>
						<select name="type1">
						<option value="drink" >饮料</option>
						<option value="food">食物</option>
						<option value="tainment">娱乐</option>
						<option value="phone">话费</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						服务类型：
					</td>
					<td>
						<label>
							<input name="type" type="text" id="type" size="40" />
						</label>
					</td>
				</tr>
				<tr>
					<td>
						消费价格：
					</td>
					<td>
						<label>
							<input name="cash" type="text" id="cash" size="40" />
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