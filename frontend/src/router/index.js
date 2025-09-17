import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/orders',
      component: () => import('../components/ui/OrderGrid.vue'),
    },
    {
      path: '/menus',
      component: () => import('../components/ui/MenuGrid.vue'),
    },
    {
      path: '/menuSoldOutHistories',
      component: () => import('../components/ui/MenuSoldOutHistoryGrid.vue'),
    },
  ],
})

export default router;
