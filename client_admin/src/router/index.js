import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},


	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},

	// 权限路由
	{
		path: '/auth/table',
		name: 'auth_table',
		component: () => import('../views/auth/table.vue'),
		meta: {
			index: 0,
			title: '权限列表'
		}
	},
	{
		path: '/auth/view',
		name: 'auth_view',
		component: () => import('../views/auth/view.vue'),
		meta: {
			index: 0,
			title: '权限详情'
		}
	},


	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
		// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},
	
	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },



	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告详情'
		}
	},


	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},

	// 注册用户路由
	{
		path: '/registered_users/table',
		name: 'registered_users_table',
		component: () => import('../views/registered_users/table.vue'),
		meta: {
			index: 0,
			title: '注册用户列表'
		}
	},
	{
		path: '/registered_users/view',
		name: 'registered_users_view',
		component: () => import('../views/registered_users/view.vue'),
		meta: {
			index: 0,
			title: '注册用户详情'
		}
	},
	// 供应商路由
	{
		path: '/supplier/table',
		name: 'supplier_table',
		component: () => import('../views/supplier/table.vue'),
		meta: {
			index: 0,
			title: '供应商列表'
		}
	},
	{
		path: '/supplier/view',
		name: 'supplier_view',
		component: () => import('../views/supplier/view.vue'),
		meta: {
			index: 0,
			title: '供应商详情'
		}
	},
	// 员工路由
	{
		path: '/staff/table',
		name: 'staff_table',
		component: () => import('../views/staff/table.vue'),
		meta: {
			index: 0,
			title: '员工列表'
		}
	},
	{
		path: '/staff/view',
		name: 'staff_view',
		component: () => import('../views/staff/view.vue'),
		meta: {
			index: 0,
			title: '员工详情'
		}
	},
	// 房间类型路由
	{
		path: '/room_type/table',
		name: 'room_type_table',
		component: () => import('../views/room_type/table.vue'),
		meta: {
			index: 0,
			title: '房间类型列表'
		}
	},
	{
		path: '/room_type/view',
		name: 'room_type_view',
		component: () => import('../views/room_type/view.vue'),
		meta: {
			index: 0,
			title: '房间类型详情'
		}
	},
	// 棋牌房间路由
	{
		path: '/chess_and_card_room/table',
		name: 'chess_and_card_room_table',
		component: () => import('../views/chess_and_card_room/table.vue'),
		meta: {
			index: 0,
			title: '棋牌房间列表'
		}
	},
	{
		path: '/chess_and_card_room/view',
		name: 'chess_and_card_room_view',
		component: () => import('../views/chess_and_card_room/view.vue'),
		meta: {
			index: 0,
			title: '棋牌房间详情'
		}
	},
	// 房间预订路由
	{
		path: '/room_reservation/table',
		name: 'room_reservation_table',
		component: () => import('../views/room_reservation/table.vue'),
		meta: {
			index: 0,
			title: '房间预订列表'
		}
	},
	{
		path: '/room_reservation/view',
		name: 'room_reservation_view',
		component: () => import('../views/room_reservation/view.vue'),
		meta: {
			index: 0,
			title: '房间预订详情'
		}
	},
	// 商品分类路由
	{
		path: '/commodity_classification/table',
		name: 'commodity_classification_table',
		component: () => import('../views/commodity_classification/table.vue'),
		meta: {
			index: 0,
			title: '商品分类列表'
		}
	},
	{
		path: '/commodity_classification/view',
		name: 'commodity_classification_view',
		component: () => import('../views/commodity_classification/view.vue'),
		meta: {
			index: 0,
			title: '商品分类详情'
		}
	},
	// 商品信息路由
	{
		path: '/product_information/table',
		name: 'product_information_table',
		component: () => import('../views/product_information/table.vue'),
		meta: {
			index: 0,
			title: '商品信息列表'
		}
	},
	{
		path: '/product_information/view',
		name: 'product_information_view',
		component: () => import('../views/product_information/view.vue'),
		meta: {
			index: 0,
			title: '商品信息详情'
		}
	},
	// 商品零售路由
	{
		path: '/commodity_retail/table',
		name: 'commodity_retail_table',
		component: () => import('../views/commodity_retail/table.vue'),
		meta: {
			index: 0,
			title: '商品零售列表'
		}
	},
	{
		path: '/commodity_retail/view',
		name: 'commodity_retail_view',
		component: () => import('../views/commodity_retail/view.vue'),
		meta: {
			index: 0,
			title: '商品零售详情'
		}
	},
	// 订单状态路由
	{
		path: '/order_signing/table',
		name: 'order_signing_table',
		component: () => import('../views/order_signing/table.vue'),
		meta: {
			index: 0,
			title: '订单状态列表'
		}
	},
	{
		path: '/order_signing/view',
		name: 'order_signing_view',
		component: () => import('../views/order_signing/view.vue'),
		meta: {
			index: 0,
			title: '订单状态详情'
		}
	},
	// 营业记录路由
	{
		path: '/business_records/table',
		name: 'business_records_table',
		component: () => import('../views/business_records/table.vue'),
		meta: {
			index: 0,
			title: '营业记录列表'
		}
	},
	{
		path: '/business_records/view',
		name: 'business_records_view',
		component: () => import('../views/business_records/view.vue'),
		meta: {
			index: 0,
			title: '营业记录详情'
		}
	},
	// 客户消费记录路由
	{
		path: '/customer_consumption_record/table',
		name: 'customer_consumption_record_table',
		component: () => import('../views/customer_consumption_record/table.vue'),
		meta: {
			index: 0,
			title: '客户消费记录列表'
		}
	},
	{
		path: '/customer_consumption_record/view',
		name: 'customer_consumption_record_view',
		component: () => import('../views/customer_consumption_record/view.vue'),
		meta: {
			index: 0,
			title: '客户消费记录详情'
		}
	},
	// 请假申请路由
	{
		path: '/employees_ask_for_leave/table',
		name: 'employees_ask_for_leave_table',
		component: () => import('../views/employees_ask_for_leave/table.vue'),
		meta: {
			index: 0,
			title: '请假申请列表'
		}
	},
	{
		path: '/employees_ask_for_leave/view',
		name: 'employees_ask_for_leave_view',
		component: () => import('../views/employees_ask_for_leave/view.vue'),
		meta: {
			index: 0,
			title: '请假申请详情'
		}
	},
	// 员工旷班路由
	{
		path: '/employee_absenteeism/table',
		name: 'employee_absenteeism_table',
		component: () => import('../views/employee_absenteeism/table.vue'),
		meta: {
			index: 0,
			title: '员工旷班列表'
		}
	},
	{
		path: '/employee_absenteeism/view',
		name: 'employee_absenteeism_view',
		component: () => import('../views/employee_absenteeism/view.vue'),
		meta: {
			index: 0,
			title: '员工旷班详情'
		}
	},
	// 员工工资路由
	{
		path: '/employee_salary/table',
		name: 'employee_salary_table',
		component: () => import('../views/employee_salary/table.vue'),
		meta: {
			index: 0,
			title: '员工工资列表'
		}
	},
	{
		path: '/employee_salary/view',
		name: 'employee_salary_view',
		component: () => import('../views/employee_salary/view.vue'),
		meta: {
			index: 0,
			title: '员工工资详情'
		}
	},
	// 员工排班路由
	{
		path: '/employee_scheduling/table',
		name: 'employee_scheduling_table',
		component: () => import('../views/employee_scheduling/table.vue'),
		meta: {
			index: 0,
			title: '员工排班列表'
		}
	},
	{
		path: '/employee_scheduling/view',
		name: 'employee_scheduling_view',
		component: () => import('../views/employee_scheduling/view.vue'),
		meta: {
			index: 0,
			title: '员工排班详情'
		}
	},
	// 发薪月份路由
	{
		path: '/pay_month/table',
		name: 'pay_month_table',
		component: () => import('../views/pay_month/table.vue'),
		meta: {
			index: 0,
			title: '发薪月份列表'
		}
	},
	{
		path: '/pay_month/view',
		name: 'pay_month_view',
		component: () => import('../views/pay_month/view.vue'),
		meta: {
			index: 0,
			title: '发薪月份详情'
		}
	},
	// 员工班时路由
	{
		path: '/employee_shift_hours/table',
		name: 'employee_shift_hours_table',
		component: () => import('../views/employee_shift_hours/table.vue'),
		meta: {
			index: 0,
			title: '员工班时列表'
		}
	},
	{
		path: '/employee_shift_hours/view',
		name: 'employee_shift_hours_view',
		component: () => import('../views/employee_shift_hours/view.vue'),
		meta: {
			index: 0,
			title: '员工班时详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "茶室管理系统-admin";
	document.title = title;
})

export default router
