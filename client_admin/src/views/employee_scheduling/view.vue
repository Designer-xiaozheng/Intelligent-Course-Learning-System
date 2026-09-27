<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','employee_no') || $check_field('add','employee_no') || $check_field('set','employee_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工工号" prop="employee_no">
													<el-select v-if="user_group === '管理员' || (form['employee_scheduling_id'] && $check_field('set','employee_no')) || (!form['employee_scheduling_id'] && $check_field('add','employee_no'))" id="employee_no" v-model="form['employee_no']" :disabled="disabledObj['employee_no_isDisabled']">
							<el-option v-for="o in list_user_employee_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','employee_no')" id="employee_no" v-model="form['employee_no']" :disabled="true">
							<el-option v-for="o in list_user_employee_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','employee_name') || $check_field('add','employee_name') || $check_field('set','employee_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工姓名" prop="employee_name">
												<el-input id="employee_name" v-model="form['employee_name']" placeholder="请输入员工姓名"
							  v-if="user_group === '管理员' || (form['employee_scheduling_id'] && $check_field('set','employee_name')) || (!form['employee_scheduling_id'] && $check_field('add','employee_name'))" :disabled="disabledObj['employee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','employee_name')">{{form['employee_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shift_month') || $check_field('add','shift_month') || $check_field('set','shift_month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="排班月份" prop="shift_month">
												<el-input id="shift_month" v-model="form['shift_month']" placeholder="请输入排班月份"
							  v-if="user_group === '管理员' || (form['employee_scheduling_id'] && $check_field('set','shift_month')) || (!form['employee_scheduling_id'] && $check_field('add','shift_month'))" :disabled="disabledObj['shift_month_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','shift_month')">{{form['shift_month']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','shift_arrangement') || $check_field('add','shift_arrangement') || $check_field('set','shift_arrangement')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="排班情况" prop="shift_arrangement">
								<el-input type="textarea" id="shift_arrangement" v-model="form['shift_arrangement']" placeholder="请输入排班情况"
						v-if="user_group === '管理员' || (form['employee_scheduling_id'] && $check_field('set','shift_arrangement')) || (!form['employee_scheduling_id'] && $check_field('add','shift_arrangement'))" :disabled="disabledObj['shift_arrangement_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','shift_arrangement')">{{form['shift_arrangement']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','leave_situation') || $check_field('add','leave_situation') || $check_field('set','leave_situation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="请假情况" prop="leave_situation">
								<el-input type="textarea" id="leave_situation" v-model="form['leave_situation']" placeholder="请输入请假情况"
						v-if="user_group === '管理员' || (form['employee_scheduling_id'] && $check_field('set','leave_situation')) || (!form['employee_scheduling_id'] && $check_field('add','leave_situation'))" :disabled="disabledObj['leave_situation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','leave_situation')">{{form['leave_situation']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "employee_scheduling_id",
				url_add: "~/api/employee_scheduling/add?",
				url_set: "~/api/employee_scheduling/set?",
				url_get_obj: "~/api/employee_scheduling/get_obj?",
				url_upload: "~/api/employee_scheduling/upload?",

				query: {
					"employee_scheduling_id": 0,
				},

				form: {
								"employee_no": 0, // 员工工号
										"employee_name":  '', // 员工姓名
										"shift_month":  '', // 排班月份
										"shift_arrangement":  '', // 排班情况
										"leave_situation":  '', // 请假情况
											"employee_scheduling_id": 0, // ID
						
				},
				disabledObj:{
								"employee_no_isDisabled": false,
										"employee_name_isDisabled": false,
										"shift_month_isDisabled": false,
										"shift_arrangement_isDisabled": false,
										"leave_situation_isDisabled": false,
										},

	
					// 用户列表
				list_user_employee_no: [],
				
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取员工用户列表
			 */
			async get_list_user_employee_no() {
                // if(this.user_group !== "管理员" && this.form["employee_no"] === 0) {
                //     this.form["employee_no"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=员工");
                if(json.result && json.result.list){
                    this.list_user_employee_no = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_employee_no(id){
				var obj = this.list_user_employee_no.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
									// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
																																	
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
														$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


															

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																					return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/employee_scheduling/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_scheduling/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_scheduling/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_scheduling/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_scheduling/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_employee_no();
													},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
