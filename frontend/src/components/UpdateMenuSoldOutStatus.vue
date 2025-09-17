<template>

    <v-card outlined>
        <v-card-title>
            UpdateMenuSoldOutStatus
        </v-card-title>

        <v-card-text>
            <Number label="MenuId" v-model="value.menuId" :editMode="editMode"/>
            <Boolean label="NewSoldOutStatus" v-model="value.newSoldOutStatus" :editMode="editMode"/>
            <String label="ChangedBy" v-model="value.changedBy" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateMenuSoldOutStatus"
            >
                UpdateMenuSoldOutStatus
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'UpdateMenuSoldOutStatusCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.menuId = 0;
        this.value.newSoldOutStatus = false;
        this.value.changedBy = '';
    },
    watch: {
    },
    methods: {
        updateMenuSoldOutStatus() {
            this.$emit('updateMenuSoldOutStatus', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

