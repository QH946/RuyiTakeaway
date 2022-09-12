// 查询列表页接口
const getOrderDetailPage = (params) => {
  return $axios({
    url: '/orderAdministration/page',
    method: 'get',
    params
  })
}

// 查看接口
const queryOrderDetailById = (id) => {
  return $axios({
    url: `/orderAdministration/orderDetail/${id}`,
    method: 'get'
  })
}

// 取消，派送，完成接口
const editOrderDetail = (params) => {
  return $axios({
    url: '/orderAdministration',
    method: 'put',
    data: { ...params }
  })
}
