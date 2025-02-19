package com.example.forumos.postdetail

import DateFormatter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forumos.R
import com.example.forumos.databinding.FragmentInsertpostBinding
import com.example.forumos.databinding.FragmentPostDetailBinding
import com.example.forumos.listposts.ListFragmentDirections
import estsetubal.ips.demontracaoForumosPosts.fragments.adapters.ForumosPostsAdapter
import java.time.format.DateTimeFormatter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PostDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostDetailFragment : Fragment() {

    private lateinit var vmodel : PostDetailViewModel
    private lateinit var _binding : FragmentPostDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vmodel = ViewModelProvider(this).get(PostDetailViewModel::class.java)

        val args: PostDetailFragmentArgs by navArgs()

        vmodel.fetchPost(args.postid)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostDetailBinding.inflate(inflater, container, false);

        vmodel.post.observe(viewLifecycleOwner) { post ->
            run {
                _binding.tvTituloMensagem.text = post.titulo
                _binding.tvMensagemPost.text = post.mensagem ?: ""
                _binding.tvAutor.text = post.autor
                _binding.tvTimestamp.text =DateFormatter.formatTimestamp(post.timestamp)

                _binding!!.rvRespostas.layoutManager = LinearLayoutManager(requireContext())
                val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL);
                _binding!!.rvRespostas.addItemDecoration(dividerItemDecoration)

                _binding!!.rvRespostas.adapter = ForumosPostsAdapter(post.respostas) { id ->
                    run {
                        val idDir = PostDetailFragmentDirections.actionPostDetailFragmentToSecondFragment(post.titulo, id);
                        findNavController().navigate(idDir)
                    }
                }

                _binding.btAddresposta.setOnClickListener {
                    findNavController().navigate(PostDetailFragmentDirections.actionPostDetailFragmentToSecondFragment(post.titulo, post.id_post))
                }
            }

        }

        return _binding.root
    }

}