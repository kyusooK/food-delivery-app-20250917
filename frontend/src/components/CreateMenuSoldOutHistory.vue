<template>

    <v-card outlined>
        <v-card-title>
            CreateMenuSoldOutHistory
        </v-card-title>

        <v-card-text>
            <Number label="MenuId" v-model="value.menuId" :editMode="editMode"/>
            <String label="ChangedBy" v-model="value.changedBy" :editMode="editMode"/>
            <Boolean label="PreviousSoldOutStatus" v-model="value.previousSoldOutStatus" :editMode="editMode"/>
            <Boolean label="NewSoldOutStatus" v-model="value.newSoldOutStatus" :editMode="editMode"/>
            <SoldOutChangeType offline label="ChangeType" v-model="value.changeType" :editMode="editMode" @change="change"/>
            <Date label="ChangedAt" v-model="value.changedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createMenuSoldOutHistory"
            >
                CreateMenuSoldOutHistory
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
    name: 'CreateMenuSoldOutHistoryCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.menuId = 0;
        this.value.changedBy = '';
        this.value.previousSoldOutStatus = false;
        this.value.newSoldOutStatus = false;
        this.value.changeType = {};
        this.value.changedAt = '2025-09-16';
    },
    watch: {
    },
    methods: {
        createMenuSoldOutHistory() {
            this.$emit('createMenuSoldOutHistory', this.value);
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

