<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','employee_no') || $check_field('add','employee_no') || $check_field('set','employee_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工工号" prop="employee_no">
													<el-select v-if="user_group === '管理员' || (form['employee_absenteeism_id'] && $check_field('set','employee_no')) || (!form['employee_absenteeism_id'] && $check_field('add','employee_no'))" id="employee_no" v-model="form['employee_no']" :disabled="disabledObj['employee_no_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['employee_absenteeism_id'] && $check_field('set','employee_name')) || (!form['employee_absenteeism_id'] && $check_field('add','employee_name'))" :disabled="disabledObj['employee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','employee_name')">{{form['employee_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','date_of_absenteeism') || $check_field('add','date_of_absenteeism') || $check_field('set','date_of_absenteeism')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="旷班日期" prop="date_of_absenteeism">
								<el-date-picker :disabled="disabledObj['date_of_absenteeism_isDisabled']" v-if="user_group === '管理员' || (form['employee_absenteeism_id'] && $check_field('set','date_of_absenteeism')) || (!form['employee_absenteeism_id'] && $check_field('add','date_of_absenteeism'))" id="date_of_absenteeism"
						v-model="form['date_of_absenteeism']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','date_of_absenteeism')">{{form['date_of_absenteeism']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','absenteeism_time') || $check_field('add','absenteeism_time') || $check_field('set','absenteeism_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="旷班时间" prop="absenteeism_time">
								<el-select id="absenteeism_time" v-model="form['absenteeism_time']"
						v-if="user_group === '管理员' || (form['employee_absenteeism_id'] && $check_field('set','absenteeism_time')) || (!form['employee_absenteeism_id'] && $check_field('add','absenteeism_time'))">
						<el-option v-for="o in list_absenteeism_time" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','absenteeism_time')">{{form['absenteeism_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','absenteeism') || $check_field('add','absenteeism') || $check_field('set','absenteeism')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="旷班情况" prop="absenteeism">
								<el-input type="textarea" id="absenteeism" v-model="form['absenteeism']" placeholder="请输入旷班情况"
						v-if="user_group === '管理员' || (form['employee_absenteeism_id'] && $check_field('set','absenteeism')) || (!form['employee_absenteeism_id'] && $check_field('add','absenteeism'))" :disabled="disabledObj['absenteeism_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','absenteeism')">{{form['absenteeism']}}</div>
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
				field: "employee_absenteeism_id",
				url_add: "~/api/employee_absenteeism/add?",
				url_set: "~/api/employee_absenteeism/set?",
				url_get_obj: "~/api/employee_absenteeism/get_obj?",
				url_upload: "~/api/employee_absenteeism/upload?",

				query: {
					"employee_absenteeism_id": 0,
				},

				form: {
								"employee_no": 0, // 员工工号
										"employee_name":  '', // 员工姓名
										"date_of_absenteeism":  '', // 旷班日期
										"absenteeism_time":  '', // 旷班时间
										"absenteeism":  '', // 旷班情况
											"employee_absenteeism_id": 0, // ID
						
				},
				disabledObj:{
								"employee_no_isDisabled": false,
										"employee_name_isDisabled": false,
										"date_of_absenteeism_isDisabled": false,
										"absenteeism_time_isDisabled": false,
										"absenteeism_isDisabled": false,
										},

	
					// 用户列表
				list_user_employee_no: [],
				
		
						// 旷班时间选项列表
				list_absenteeism_time: ['早班','中班','晚班'],
	
		
	
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
						        if (this.form["date_of_absenteeism"].indexOf("-")===-1){
          this.form["date_of_absenteeism"] = this.$toTime(parseInt(this.form["date_of_absenteeism"]),"yyyy-MM-dd")
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


								        if(this.form["date_of_absenteeism"]=="0000-00-00"){
          this.form["date_of_absenteeism"] = null;
        }
				if(parseInt(this.form["date_of_absenteeism"]) > 9999){
					this.form["date_of_absenteeism"] = this.$toTime(parseInt(this.form["date_of_absenteeism"]),"yyyy-MM-dd")
				}
								

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
					bl = this.$check_action('/employee_absenteeism/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_absenteeism/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_absenteeism/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_absenteeism/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employee_absenteeism/view','get');
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
