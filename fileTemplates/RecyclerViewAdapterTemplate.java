#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public class ${NAME} extends RecyclerView.Adapter<${NAME}.ViewHolder> {

    private static final String TAG = ${NAME}.class.getSimpleName();
    private Context mContext;
    private List<${LIST_MODEL}> mList;
    private OnItemClickListener mListener;

    public ${NAME}(Context context, List<${LIST_MODEL}> list, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = onItemClickListener;
    }
	
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.${item_layout}, parent, false);
        return new ViewHolder(view);
    }
	
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ${LIST_MODEL} item = mList.get(position);
		
		//TODO setup views
		
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(model);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(${LIST_MODEL} item);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
		
		//TODO Bind views
		public ViewHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
        }
    }
}