<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','room_name') || $check_field('add','room_name') || $check_field('set','room_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="房间名称" prop="room_name">
												<el-input id="room_name" v-model="form['room_name']" placeholder="请输入房间名称"
							  v-if="user_group === '管理员' || (form['chess_and_card_room_id'] && $check_field('set','room_name')) || (!form['chess_and_card_room_id'] && $check_field('add','room_name'))" :disabled="disabledObj['room_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','room_name')">{{form['room_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','room_type') || $check_field('add','room_type') || $check_field('set','room_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="房间类型" prop="room_type">
								<el-select id="room_type" v-model="form['room_type']"
						v-if="user_group === '管理员' || (form['chess_and_card_room_id'] && $check_field('set','room_type')) || (!form['chess_and_card_room_id'] && $check_field('add','room_type'))">
						<el-option v-for="o in list_room_type" :key="o['room_type']" :label="o['room_type']"
							:value="o['room_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','room_type')">{{form['room_type']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_rooms') || $check_field('add','number_of_rooms') || $check_field('set','number_of_rooms')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="房间数量" prop="number_of_rooms">
								<el-input-number id="number_of_rooms" v-model.number="form['number_of_rooms']"
						v-if="user_group === '管理员' || (form['chess_and_card_room_id'] && $check_field('set','number_of_rooms')) || (!form['chess_and_card_room_id'] && $check_field('add','number_of_rooms'))" :disabled="disabledObj['number_of_rooms_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_rooms')">{{form['number_of_rooms']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','picture') || $check_field('add','picture') || $check_field('set','picture')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="图片" prop="picture">
								<el-upload :disabled="disabledObj['picture_isDisabled']" id="picture" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_picture"
						:show-file-list="false" v-if="user_group === '管理员' || (form['chess_and_card_room_id'] && $check_field('set','picture')) || (!form['chess_and_card_room_id'] && $check_field('add','picture'))">
						<img v-if="form['picture']" :src="$fullUrl(form['picture'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','picture')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['picture'])" :preview-src-list="[$fullUrl(form['picture'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','price') || $check_field('add','price') || $check_field('set','price')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="价格" prop="price">
								<el-input-number id="price" v-model.number="form['price']"
						v-if="user_group === '管理员' || (form['chess_and_card_room_id'] && $check_field('set','price')) || (!form['chess_and_card_room_id'] && $check_field('add','price'))" :disabled="disabledObj['price_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','price')">{{form['price']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','room_facilities') || $check_field('add','room_facilities') || $check_field('set','room_facilities')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="房间设施" prop="room_facilities">
								<el-input type="textarea" id="room_facilities" v-model="form['room_facilities']" placeholder="请输入房间设施"
						v-if="user_group === '管理员' || (form['chess_and_card_room_id'] && $check_field('set','room_facilities')) || (!form['chess_and_card_room_id'] && $check_field('add','room_facilities'))" :disabled="disabledObj['room_facilities_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','room_facilities')">{{form['room_facilities']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','room_introduction') || $check_field('add','room_introduction') || $check_field('set','room_introduction')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="房间介绍" prop="room_introduction">
								<el-input type="textarea" id="room_introduction" v-model="form['room_introduction']" placeholder="请输入房间介绍"
						v-if="user_group === '管理员' || (form['chess_and_card_room_id'] && $check_field('set','room_introduction')) || (!form['chess_and_card_room_id'] && $check_field('add','room_introduction'))" :disabled="disabledObj['room_introduction_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','room_introduction')">{{form['room_introduction']}}</div>
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
				field: "chess_and_card_room_id",
				url_add: "~/api/chess_and_card_room/add?",
				url_set: "~/api/chess_and_card_room/set?",
				url_get_obj: "~/api/chess_and_card_room/get_obj?",
				url_upload: "~/api/chess_and_card_room/upload?",

				query: {
					"chess_and_card_room_id": 0,
				},

				form: {
								"room_name":  '', // 房间名称
										"room_type":  '', // 房间类型
										"number_of_rooms":  0, // 房间数量
										"picture":  '', // 图片
										"price":  0, // 价格
										"room_facilities":  '', // 房间设施
										"room_introduction":  '', // 房间介绍
											"chess_and_card_room_id": 0, // ID
						
				},
				disabledObj:{
								"room_name_isDisabled": false,
										"room_type_isDisabled": false,
					          			"number_of_rooms_isDisabled": false,
										"picture_isDisabled": false,
					          			"price_isDisabled": false,
										"room_facilities_isDisabled": false,
										"room_introduction_isDisabled": false,
										},

	
						// 房间类型选项列表
				list_room_type: [""],
	
		
		
		
		
		
	
			}
		},
		methods: {


	
	
			
				/**
			 * 获取房间类型列表
			 */
			async get_list_room_type() {
				var json = await this.$get("~/api/room_type/get_list?");
				if(json.result && json.result.list){
					this.list_room_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
						/**
			 * 上传图片
			 * @param {Object} param 图片参数
			 */
			upload_picture(param){
						this.uploadFile(param.file, "picture");
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
					bl = this.$check_action('/chess_and_card_room/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/chess_and_card_room/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/chess_and_card_room/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/chess_and_card_room/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/chess_and_card_room/view','get');
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
						this.get_list_room_type();
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
